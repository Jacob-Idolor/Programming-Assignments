#lab6s5 this scripts works on a linux system I used ubuntu as the operating system
# The Language I used was python the latest version
# Jacob Idolor 
import random 
number = random.randrange(1,11) 
cont = False 
while cont is False:
 print("I am thinking of a number between 1 and 10. Enter your guess") 
 guess = input()
 if guess == number: 
	print("Yes! " + str(guess) + " is the correct number") 
	cont is True
	break
 elif guess > number: 
	print("The Secret number is smaller then your guess try again") 
	cont is False 
 elif guess < number: 
	print("The Secret number is larger then your guess try again") 
	cont is False