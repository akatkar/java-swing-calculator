# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 6 : Refactored switch in actionPerformed  
 - Operator enum extracted  from Calculator and added Symbol
 - fromString method added to Operator enum to be able to find Operator
 - DIGIT and OPERATORS patterns added to be able to recognize which key pressed
 - Switch statement replaced with pattern matcher 
 
 Now we have a if-else chain instead of switch statement but this block is shorter. 
 We will refactor it again later 
   
# Current Status at Step 6  
## Code smells to be able to refactor
 - In Calculator class; switch in pressedOperator should be removed
 - In Calculator class; if-else block in actionPerformed should be removed

## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - refactor switch in pressedOperator