.equ SWI_PrInt,0x6b 
.equ SWI_PrStr, 0x69 
.equ Stdout, 1 
.equ SWI_Exit, 0x11 


MOV R7 , #1000 @TOTAL COUNT 
MOV R5, #1 @INTIALIZER OR I 
MOV R6, #1 @ COUNT TO FIVE 
LOOPSTART: 
CMP R5 , R7
BLE LOOPBODY
swi SWI_Exit


LOOPBODY: 
CMP R6, #5 
BEQ LOOPVARIANTRESET  
MOV R0, #Stdout
MOV R1 , R5
swi SWI_PrInt
MOV R0, #Stdout
LDR R1 , =EOL
swi SWI_PrStr
B LOOPVARIANT


LOOPVARIANTRESET:
MOV R6, #0 


LOOPVARIANT:
ADD R6, R6,#1 
ADD R5, R5,#1
B LOOPSTART

EOL: .asciz "\n"