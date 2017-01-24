#functions 

module Functs_Idolor
#####################
def add_record()
# prompt/chomp for id, check if exists if (@record[id]) ,  so return 
puts("Please enter student Id") 
id = gets.chomp
if (@record[id]) 
puts("Student aready exists") 
return 
end 
#prompt for lname fname major year 
print("Enter Last name ")
lname = gets.chomp 
print("Enter first name ") 
fname = gets.chomp
print("Enter Major ") 
major = gets.chomp
print("Enter catalog year ") 
catalog = gets.chomp 
print("New record addded ") 
entry = lname + "," + fname + "," + major + "," + catalog
@record[id] = entry 
#add entry into new hash: @rec w/key "id value append field 
end 

################
def edit_record()
# prompt/chomp for id, check if doestn exists if (!@record[id]) ,  so return
print("Please enter id you want to update ")
id = gets.chomp 
if (!@record[id])
puts("no record found") 
return
end 
puts("Modify last name ")
print("Current Value ") 
lname = gets.chomp 
print("New Value ") 
lname = gets.chomp
#prompt for lname fname major year 

puts("Modify first name ") 
print("Current Value ") 
fname = gets.chomp
print("New Value ") 
fname = gets.chomp 

puts("Modify Major ") 
print("Current Value ") 
major = gets.chomp 
print("New Value ") 
major = gets.chomp


puts("Modify Year ") 
print("Current Value " + catalog) 
catalog = gets.chomp 
print("New Value ") 
catalog = gets.chomp 
entry = lname + "," + fname + "," + major + "," + catalog
# appened fields var = lname + "," fname ....
#add entry into new hash: @rec w/key "id value append field 
@record[id] = entry
print("Record has been Changed ") 
end 

###############
def remove_record()

# prompt/chomp for id, check if doestn exists if (!@record[id]) ,  so return
puts("Enter Student Id you want to delete") 
id = gets.chomp 
if (!@record[id])
puts("student id not found ") 
return 
end 
#remove form hash 
@record.delete(id)
print("Record Deleted ") 
end 



###### 
def display_record()
#copy from quit program instead ----> puts to screen 
#split value by "," and print w/ "\t"
puts("------------------------------------------------------------------------")
    puts("ID \t\t | Last Name \t | First Name \t | Major \t | Year")
    puts("------------------------------------------------------------------------")
	@record.each do|key,value|
       fields = value.split(",")
       
       #print ID
       print key
       if key.length < 5
         print ("\t")
       end
       print "\t | "
       
       #print last name
       print lname = fields[0]
       if lname.length < 5
         print("\t")
       end
       print "\t | "
       
       #print first name
       print fname = fields[1]
       if fname.length < 5
         print("\t")
       end
       print "\t | "
       
       #print major
       print major = fields[2]
       if major.length < 5
         print("\t")
       end
       print "\t | "
       
       #print year
       puts catalog = fields[3]
    end
    puts("------------------------------------------------------------------------")
  end
end 


 
##module