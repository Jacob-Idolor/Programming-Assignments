require "#{File.dirname(__FILE__)}/Functs_Idolor"
class StudentDB
	include Functs_Idolor
def initialize()
@record=Hash.new
#input text file 
print("Enter Database filename ") 
#prompt filename 
@fn = gets.chomp

if File::exists?(@fn)
	@fh = File.open(@fn, 'r') 
	while line= @fh.gets 
	linearray = line.split(":") 
	my_keys=linearray[0]
	my_values= linearray[1]
	@record[my_keys] = my_values 
	end 
else  
@fh = File.open(@fn, 'a+')
end 
end
#ifexists 
def quit_program()

#prompt to save records  (y/n)
print("Save Records? 'y' = yes  'n'= no ")
savefile = gets.chomp
if (savefile == 'y') 
@fh.close()
@fh = File.open(@fn, 'w') 
#if so, close @fh , reopen for writing 
#for each line write to the file 
@record.each do |key , value|
 appended_string = key + ":" + value 
 @fh.puts(appended_string) 
end 
#each do 
@fh.close()
#close file @fh 
end 
end
end
db = StudentDB.new 
choice = '0'
while (choice!='q') 
# loop until user quits ---> prompt for choice, call appropiate method 
puts() 
puts("Student Database") 
puts("----------------") 
puts("a = Add new record") 
puts("e = Edit exisiting record in database") 
puts("r = Remove exisiting record from databse") 
puts("d = Display record(s) in database") 
puts("q = Quit")
puts("ENTER CHOICE: " ) 
choice = gets.chomp
case (choice) 
when 'a' 
	db.add_record() 
when 'e' 
	db.edit_record()
when 'q' 
	db.quit_program()
when 'd'
	db.display_record()
when 'r'
	db.remove_record()
	end
end 