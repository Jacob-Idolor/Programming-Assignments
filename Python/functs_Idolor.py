import re 

############################ new_user function ###############################
def new_user(local_hash): 

	# prompt for username 
	print ("Please Enter a Username\n")
	username  = input()
	# strip off special chars from username (ref asmt sheet)
	username = re.sub(r'\W+','',username)
	# convert username to lowercase (ref asmt sheet)
	username = username.lower()
	#check if username already exists & if so exit, else assign password as value to the hash referenced by username as the key
	if (username in local_hash):
	 print ("Username name already exisits") 
	 return local_hash
	print ("Please Enter a Password")
	password = input()
	# strip off apostrophe from password (ref asmt sheet)
	password = password.replace('\'', '')
	local_hash[username] = password
	return local_hash
	
	
	
	

############################ edit_user function ###############################
def edit_user(local_hash):

	# prompt for username 
	print ("Please Enter a Username\n")
	username  = input()
	# strip off special chars from username (ref asmt sheet)
	username = re.sub(r'\W+','',username)
	# convert username to lowercase (ref asmt sheet)
	username = username.lower()
	#check if username already exists & if so exit, else assign password as value to the hash referenced by username as the key
	if (username not in local_hash):
	 print ("Username name does not exisit") 
	 return local_hash
	#prompt/chomp for current password
	print ("Enter Password to edit account")
	password = input() # strip off apostrophe from password (ref asmt sheet)
	password = password.replace('\'', '')
	#check if password DOESNT exist & if NOT so exit
	if (local_hash[username] == password) : 
	#prompt/chomp for new password
	 print ("Enter New Password" ) 
	 newpassword = input() 
	# strip off apostrophe from password (ref asmt sheet)
	 newpassword = newpassword.replace('\'', '')
	# assign password as value to the hash referenced by username as the key
	 local_hash[username] = newpassword
	else : 
	 return local_hash
	return local_hash 

############################ delete_user function ###############################
def delete_user(local_hash):

	# prompt/chomp for username
	print ("Enter Username to delete") 
	username = input() 
	# strip off special chars from username (ref asmt sheet)
	username = re.sub(r'\W+','',username)
	# convert username to lowercase (ref asmt sheet)
	username = username.lower()
	#check if username DOESNT already exists & if NOT so exit
	if (username in local_hash):
	#delete key from hash (ref slides)
	 del (local_hash[username] )
	 print ("User deleted") 
	 return local_hash
	else: 
	 print ("Username does not exist") 
	return local_hash

############################ list_accounts function ###############################
def list_accounts(local_hash):

	# print out to the screen each key & value pair from hash
	for k,v in local_hash.items():
	 print(k + ":" + v + "\n" ) 
	return local_hash



























