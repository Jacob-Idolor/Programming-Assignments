#lab6s6 for the Client this scripts works on a linux system I used ubuntu as the operating system
# The Language I used was python the latest version
# Jacob Idolor 
import socket
s = socket.socket()
host = socket.gethostname()
port =  1738
s.connect((host, port)) 
print s.recv(1024) 
s.close