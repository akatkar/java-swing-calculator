# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 3 : Refactored lambda  
 - SetVisible moved from Main method into Calculator's constructor
 - Now we can use constructor reference in lambda 
  
# Current Status at Step 3  
## Code smells to be able to refactor
 - In Calculator class; switch in pressedOperator should be removed
 - In Calculator class; switch in actionPerformed should be removed
 - In Calculator class; displayValue should be in Display Class 

## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - displayValue can be moved to Display Class
