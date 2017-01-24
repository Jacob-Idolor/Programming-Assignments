#lab6s3 this scripts works on a linux system I used ubuntu as the operating system
# The Language I used was python the latest version
# Jacob Idolor 
import sys
import os
print ("Please Enter the folder path that you would like to touch") 
directory = raw_input()
if os.path.isdir(directory) is  False :
 print("Directory Does Not Exist Try Again") 
else :
 path = os.listdir(directory)
 
 for filename in path:
	print(filename) 
	file = open(directory + "/" + str(filename), 'r' ) 
	length = file.read()
	print("The file has " +  str(len(length.strip()) ) + " characters") 
	print("The file is " +  str(os.stat(directory + "/" + str(filename)).st_size)+ " bytes")
	
	