package functs_Idolor; 


# Export functions--copy next 4 lines verbatim
use Exporter;
use warnings;
use vars qw (@ISA @EXPORT);
@ISA = qw(Exporter);
@EXPORT = ("new_user", "edit_user", "delete_user", "list_accounts"); 

use strict;  
my $username;
my $password;
my $param; 

############################ new_user function ###############################
sub new_user 
{
 $param = shift;
my %local_hash = %$param;

#prompt/chomp for username & password
print " Enter a Username\n";
 $username = <>; 
chomp ($username); 
# strip off special chars from username (ref asmt sheet)
$username=~ s/[^a-zA-Z0-9]//g;
# convert username to lowercase (ref asmt sheet)
$username = lc($username); 
#check if username already exists & if so exit, else assign password as value to the hash referenced by username as the key
if (exists($local_hash{$username})){ 
print "Username Already Exisits Try Again \n "; 
return %local_hash;
}
 print "Username Did Not Exist Creating New User\n";  
 # strip off apostrophe from password (ref asmt sheet)$
print "Enter a Password\n";
 $password = <> ; 
chomp ($password);
 $password =~ s/\'//g;
 $local_hash {$username} = $password; 
 return %local_hash;
 

}
############################ edit_user function ###############################
sub edit_user 
{
 $param = shift;
my %local_hash = %$param;

#prompt/chomp for username
print "Enter Username To Edit\n"; 
my $username = <>; 
chomp ($username); 
# strip off special chars from username (ref asmt sheet)
$username=~ s/[^a-zA-Z0-9]//g;
# convert username to lowercase (ref asmt sheet)
$username = lc($username); 
#check if username DOESNT already exists & if NOT so exit
if ( !exists ($local_hash {$username})) { 
print "Sorry There Is No User With That Name";
return %local_hash; 
} 
#prompt/chomp for current password
print "User Exists Enter Password to Edit User\n"; 
my $password = <>; 
chomp($password); 
# strip off apostrophe from password (ref asmt sheet)
$password =~ s/\'//g;
#check if password DOESNT exist & if NOT so exit
if (!exists ($local_hash {$password}))  {
print "Wrong Password Try Again\n"; 
return %local_hash; 
}
print "Please Enter New Password\n"; 
#prompt/chomp for new password
my $Newpassword = <>; 
chomp ($Newpassword) ; 
# strip off apostrophe from password (ref asmt sheet)
 $Newpassword =~ s/\'//g;
# assign password as value to the hash referenced by username as the key
$local_hash{$username} = $Newpassword; 
return %local_hash;
}


############# delete_user function ###############################
sub delete_user {
 $param = shift;
my  %local_hash = %$param;

#prompt/chomp for username
print "Please Enter User You Want to Delete\n"; 
my $username = <>;
# strip off special chars from username (ref asmt sheet)
$username=~ s/[^a-zA-Z0-9]//g; 
# convert username to lowercase (ref asmt sheet)
$username = lc($username); 
#check if username DOESNT already exists & if NOT so exit
if ( !exists ($local_hash {$username})){
print "User Does Not Exist\n"
}

else {
#delete key from hash (ref slides)
delete ($local_hash{$username});
}
return %local_hash;
}
############################ list_accounts function ###############################
sub list_accounts {
$param = shift;
my %local_hash = %$param;

# print out to the screen each key & value pair from hash (ref .pl file when the hash is wriiten to a file)

		for my $key(keys %local_hash){
		print "$key : $local_hash{$key}\n";
		}
		return %local_hash;
}

1;