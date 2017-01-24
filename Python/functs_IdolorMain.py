 import functs_Idolor.py 

# create a list of functions
function = ['a', 'u', 'd','p', 'q']
#global var declarations go here
hashVar = {}
#Open file for reading
filename = input("What File Would You Like To Open? Please Enter It Now")
# prompt user for filename & store in variable:"fn"
fn = open(filename , "a")
#transfer file line by line into hash with a while loop, splitting the username and password by the delimiter character ":"
linearray = fh.readlines()
for i in range(len(linearray)):
     line = linearray[i].split(":")
     username = line[0]
     password = line[1].strip()
     hash[username] = password	 
	 
choice=''
# outer loop until user quits
while (choice!=q):
	#inner loop until user enters correct option
	while(1):
	# print menu & prompt/chomp for user input: $choice
	 print ("User Account Options\n") 
	 print ("--------------------\n")
	 print ("n New User Account\n")
	 print ("e = Edit Exisisting Account\n") 
	 print ("d = Delete User Account\n") 
	 print ("q = Quit\n") 
	 print("Enter Choice") 
		# if user enters 'q' then quit by exiting outer loop
	 choice = input() 
		# if the user enters a valid choice, exit inner loop	
	 if choice in function:
	 break
	 else: 
	 print ("Choice Unknown\n") 
 	# call appropriate function referenced by: "functs_yourlastname.function" and assign the function result to the hash to update it
	if choice == "n":
		hash = function_Idolor.new_user(hash) 
	elif choice == "e":
		hash = function_Idolor.edit_user(hash) 
	elif choice == "d":
		hash = function_Idolor.delete_user(hash) 
	elif choice == "l": 
		hash = fucntion_Idolor.list_accounts(hash) 
	else: 
		pass
	

#Close the file for reading
print("Do you want to save (y/n?)\n") 
closefile = input()
if closefile == 'y':
 fn.close()
 fn = open(filename , "w")
 for k,v in hash.items():
  information = k + ":" + v + "\n"
  fn.write(information)
fn.close()   
# prompt user to save changes, if so, then print the entire contents of the hash to the file & close the file for writing




