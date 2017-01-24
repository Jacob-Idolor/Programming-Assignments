#lab6s6 for the server  this scripts works on a linux system I used ubuntu as the operating system
# The Language I used was python the latest version
# Jacob Idolor 
import socket 
import datetime
import time 
s= socket.socket() 
host = socket.gethostname() 
port = 1738
s.bind((host, port)) 
print(host)
print(port) 
s.listen(5)
while True: 
	c,addr = s.accept()
	time = time.strftime( "%a %b %d, %I:%M:%S %p",time.localtime(time.time()))
	c.send(str(time))
	c.close()