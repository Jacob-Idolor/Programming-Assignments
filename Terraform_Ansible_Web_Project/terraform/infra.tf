# Add your VPC ID to default below
variable "vpc_id" {
  description = "VPC ID for usage throughout the build process"
  default     = "vpc-6115e706"
}

provider "aws" {
  region = "us-west-2"
}


# The Following will Create a single internet gateway used for  the public routing table 
resource "aws_internet_gateway" "gw" {
  vpc_id = "${var.vpc_id}"

  tags = {
    Name = "default_ig"
  }
}


# This will assign and elastic ip and assgin it to NAT gateway
resource "aws_eip" "tuto_eip" {
  vpc = true
  
}


# This will make a private NAT gateway in any region and place in private route
resource "aws_nat_gateway" "NAT_gateway" {
    allocation_id = "${aws_eip.tuto_eip.id}"
    subnet_id = "${aws_subnet.public_subnet_a.id}"
	
}


#This will make a private routing table with NAT gateway 
resource "aws_route_table" "private_routing_table" {
    vpc_id = "${var.vpc_id}"
    route {
        cidr_block = "0.0.0.0/0"
        nat_gateway_id = "${aws_nat_gateway.NAT_gateway.id}"
    }

    tags {
        Name = "private_routing_table"
    }
}


# This will make a public route table and assign it the internet gateway to it
resource "aws_route_table" "public_routing_table" {
  vpc_id = "${var.vpc_id}"
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.gw.id}"
  }

  tags {
    Name = "public_routing_table"
  }
}


# This is the first public subnet CIDR Block 172.31.25.0/24
resource "aws_subnet" "public_subnet_a" {
  vpc_id            = "${var.vpc_id}"
  cidr_block        = "172.31.25.0/24"
  availability_zone = "us-west-2a"

  tags {
    Name = "public_a"
  }
}

# This is the public table association for public subnet a 
resource "aws_route_table_association" "public_subnet_a_rt_assoc" {
  subnet_id = "${aws_subnet.public_subnet_a.id}"
  route_table_id = "${aws_route_table.public_routing_table.id}"
}

#This is the second public subnet CIDR Block 172.31.2.0/24 
resource "aws_subnet" "public_subnet_b" {
  vpc_id            = "${var.vpc_id}"
  cidr_block        = "172.31.2.0/24"
  availability_zone = "us-west-2b"

  tags {
    Name = "public_b"
  }
}

#public table association for public subnet b 
resource "aws_route_table_association" "public_subnet_b_rt_assoc" {
  subnet_id      = "${aws_subnet.public_subnet_b.id}"
  route_table_id = "${aws_route_table.public_routing_table.id}"
}


#This is the third publi subnet CIDR Block 172.31.3.0/24
resource "aws_subnet" "public_subnet_c" {
  vpc_id            = "${var.vpc_id}"
  cidr_block        = "172.31.3.0/24"
  availability_zone = "us-west-2c"

  tags {
    Name = "public_c"
  }
}


#public table association for public subnet c 
resource "aws_route_table_association" "public_subnet_c_rt_assoc" {
  subnet_id      = "${aws_subnet.public_subnet_c.id}"
  route_table_id = "${aws_route_table.public_routing_table.id}"
}


#PRIVATE SUBNET IP CIDR BLOCK MUST BE /22 


#This will make the first private subnet CIDR Block 172.31.60.0/22
resource "aws_subnet" "private_subnet_a" {
  vpc_id            = "${var.vpc_id}"
  cidr_block        = "172.31.60.0/22"
  availability_zone = "us-west-2a"

  tags {
    Name = "private_a"
  }
}

#private table association for private subnet a 
resource "aws_route_table_association" "private_subnet_a_rt_assoc" {
  subnet_id      = "${aws_subnet.private_subnet_a.id}"
  route_table_id = "${aws_route_table.private_routing_table.id}"
}


#This will make the second private subnet CIDR Block 172.31.10.0/22
resource "aws_subnet" "private_subnet_b" {
  vpc_id            = "${var.vpc_id}"
  cidr_block        = "172.31.10.0/22"
  availability_zone = "us-west-2b"

  tags {
    Name = "private_b"
  }
}

#private table association for private subnet b 
resource "aws_route_table_association" "private_subnet_b_rt_assoc" {
  subnet_id      = "${aws_subnet.private_subnet_b.id}"
  route_table_id = "${aws_route_table.private_routing_table.id}"
}


#This will make the third private subnet CIDR Block 172.31.15.0/22  
resource "aws_subnet" "private_subnet_c" {
  vpc_id            = "${var.vpc_id}"
  cidr_block        = "172.31.15.0/22"
  availability_zone = "us-west-2c"

  tags {
    Name = "private_c"
  }
}


#private table association for private subnet c 
resource "aws_route_table_association" "private_subnet_c_rt_assoc" {
  subnet_id      = "${aws_subnet.private_subnet_c.id}"
  route_table_id = "${aws_route_table.private_routing_table.id}"
}


#EC2 instance 
# t2.micro node with an AWS Tag naming it "Bastion"

resource "aws_instance" "web" {
    ami = "ami-5ec1673e"
    instance_type = "t2.micro"
	subnet_id = "${aws_subnet.public_subnet_a.id}"
	associate_public_ip_address = "true"
	key_name = "cit360"
	vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
    tags {
        Name = "Bastion"
    }
}


# THis will make a realational db instance can be connected to by installing client. 
resource "aws_db_instance" "default" {
  allocated_storage    = 5
  engine               = "mariadb"
  engine_version       = "10.0.24"
  instance_class       = "db.t2.micro"
  name                 = "mymariadb"
  username             = "root"
  password             = "mastermaster"
  multi_az             = "FALSE"
  storage_type         = "gp2"
  db_subnet_group_name = "${aws_db_subnet_group.dbsub.id}"
  vpc_security_group_ids = ["${aws_security_group.fordb.id}"]
  
}


#This will make the first webserver that will hose the curriculm website 
resource "aws_instance" "webserver-b" {
    ami = "ami-5ec1673e"
    instance_type = "t2.micro"
	subnet_id = "${aws_subnet.private_subnet_b.id}"
	associate_public_ip_address = "true"
	key_name = "cit360"
	security_groups = ["${aws_security_group.allow_outside.id}"]
    tags {
        Name = "webserver-b"
		Service = "curriculum" 
    }
}


#this will make another instacne that will be the backup server if the other one hits alot of traffic
resource "aws_instance" "webserver-c" {
    ami = "ami-5ec1673e"
    instance_type = "t2.micro"
	subnet_id = "${aws_subnet.private_subnet_c.id}"
	associate_public_ip_address = "true"
	key_name = "cit360"
	security_groups = ["${aws_security_group.allow_outside.id}"]
    tags {
        Name = "webserver-c"
		Service = "curriculum" 
    }
}

#THis will make a ELB and put the two webservers instances attached to it 
resource "aws_elb" "forinstance" {
  name = "instances-terraform-elb"
  
  security_groups = ["${aws_security_group.allow_ELB.id}"]
  subnets = ["${aws_subnet.public_subnet_c.id}" , "${aws_subnet.public_subnet_b.id}"]
  
  listener {
    instance_port = 80
    instance_protocol = "http"
    lb_port = 80
    lb_protocol = "http"
  }


  health_check {
    healthy_threshold = 2
    unhealthy_threshold = 2
    timeout = 5
    target = "HTTP:80/"
    interval = 30
  }

  instances = ["${aws_instance.webserver-b.id}","${aws_instance.webserver-c.id}"]
  cross_zone_load_balancing = true
  idle_timeout = 400
  connection_draining = true
  connection_draining_timeout = 60
  security_groups = ["${aws_security_group.allow_ELB.id}"]
  tags {
    Name = "Two-instances-terraform-elb"
  }
}


#The following are security groups that allow certain actions and privledges 


#security group allow on port 22 aka ssh access 
resource "aws_security_group" "allow_ssh" {
  name = "allow_ssh"
  description = "Allow traffic on port 22 for ssh"
vpc_id = "${var.vpc_id}"
  ingress {
      from_port = 22
      to_port = 22
      protocol = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
      from_port = 0
      to_port = 0
      protocol = "-1"
      cidr_blocks = ["0.0.0.0/0"]
      
  }
}





#secuirty group for the ec2 instance DB this will allow accessto realational db
resource "aws_security_group" "fordb" {
  name = "fordb"
  description = "for db"

  ingress {
      from_port = 3306
      to_port = 3306
      protocol = "tcp"
      cidr_blocks = ["172.31.0.0/16"]
  }

  tags {
    Name = "fordb"
  }
}



#subnet group for the DB this will allow the two webservers to have private ip and communocate with bastion instance
resource "aws_db_subnet_group" "dbsub" {
    name = "main"
    subnet_ids = ["${aws_subnet.private_subnet_a.id}", "${aws_subnet.private_subnet_b.id}"]
    tags {
        Name = "My DB subnet group"
    }
}


#security group for instances with rules
resource "aws_security_group" "allow_outside" {
  name = "allow_outside"
  description = "Allow port 80 and 22 to outside "

  ingress {
      from_port = 80
      to_port = 80
      protocol = "TCP"
      cidr_blocks = ["172.31.0.0/16"]
  }
  ingress {
      from_port = 22
      to_port = 22
      protocol = "TCP"
      cidr_blocks = ["172.31.0.0/16"]
  }

  egress {
      from_port = 0
      to_port = 0
      protocol = "-1"
      cidr_blocks = ["0.0.0.0/0"]
      
  }
}
# security group for ELB
resource "aws_security_group" "allow_ELB" {
  name = "allow_ELB"
  description = "Allow ELB for port 80"
  vpc_id = "${var.vpc_id}"
  ingress {
      from_port = 80
      to_port = 80
      protocol = "TCP"
      cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
      from_port = 0
      to_port = 0
      protocol = "-1"
      cidr_blocks = ["0.0.0.0/0"]
      
  }
}


