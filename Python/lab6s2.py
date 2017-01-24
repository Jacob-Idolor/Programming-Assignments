#lab6s2 this scripts works on a linux system I used ubuntu as the operating system
# The Language I used was python the latest version
# Jacob Idolor 
import os 
import datetime 
import time 

Current_Time = time.strftime("%I:%M") 
Current_Date = time.strftime("%x") 
Logged_In = os.popen('who').read()
Uptime = os.popen("uptime").read() 
filename = "lab6s2.log"
filehandle = open(filename , "a+") 
filehandle = open(filename , "w") 

filehandle.write(Current_Time + '\n') 
filehandle.write(Current_Date + '\n')
filehandle.write(Logged_In + '\n') 
filehandle.write(Uptime + '\n')
filehandle.close()
