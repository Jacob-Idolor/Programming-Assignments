 use strict; 
 use functs_Idolor; 

# create a hash of functions
my %function = ('n' =>\ &new_user, 'e' =>\ &edit_user , 'd' => \ &delete_user, 'l' => \ &list_accounts) ; 
#global var declarations go here
my %hash; 
my $choice;
#Open file for reading
# prompt user for filename & store in variable:"fn"  : print, <>, chomp
print "What File Would you Like to Open\n"; 
my $fn = <>; 
chomp ($fn); 
open (my $fh, "<",  $fn ); 
# if file does not exist, create it
if (!$fh) {

open (my $fh , ">", $fn ) ; 
	} 
	
#transfer file line by line into hash with a while loop, splitting the username and password by the delimiter character ":"
while (my $line = <$fh>) {

my @line_array = split(/:/ , $line ) ; 
my $username =  $line_array[0] ;
my $password =  $line_array[1] ; 
chomp ($password ); 
 $hash{$username} = $password; 
} 
# outer loop until user quits
outer_loop: while (1) {
	#inner loop until user enters correct option
inner_loop:  while (1) {

	# print menu & prompt/chomp for user input: $choice
	
	print "User Accounts\n";
	print "----------------\n";
	print " n = New User Account\n";
	print " e = Edit Existing User Account\n";
	print " d = Delete Exisiting User Account\n" ;
	print " l = List User Accounts\n";
	print " q = Quit \n";
	
	print "Enter Choice \n ";
	$choice = <>; 
	chomp ($choice);
# is uer enters 'q' then quit by exiting outer loop
if ($choice eq 'q' ) {
last outer_loop;
}
# if the user enters a valid choice, exit inner loop	
if (exists ($function {$choice} )) { last inner_loop; } 

print "Unknown Choice\n"; 

# set local variable to appropriate function references in hash by user's choice & call appropriate function by passing in the hash as a parameter and assigning the function result to the hash to update it
}
my $selection =  $function {$choice} ; 
%hash = $selection -> (\%hash); 
}

#Close the file for reading
close ($fh); 
# prompt user to save changes, if so, then print the entire contents of the hash to the file & close the file for writing

print "Save Changes?(y/n)?\n";
my $saveit = <>; 
chomp($saveit); 
if ( $saveit eq ('y')){ 
open ($fh,">", $fn); 
for my $key(keys %hash ) {
print $fh $key.":". $hash {$key}."\n"; 
}
close ($fh); 
print "Usernames and Passwords saved\n";
}