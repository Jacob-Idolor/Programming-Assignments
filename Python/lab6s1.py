#lab6s1 this scripts works on a linux system I used ubuntu as the operating system
# The Language I used was python the latest version
# Jacob Idolor 
filename = "file" 
filenumber = 0 

while (filenumber <10) :
  filehandle = open (filename+str(filenumber) , "a+")
  filehandle = open (filename+str(filenumber) , "w") 
  text = "Hello, this is the first line of file" + str(filenumber) 
  filehandle.write(text) 
  filehandle.close() 
  filenumber = filenumber + 1 