# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 5 : Refactored isDotPressed variable  
 in Display class:
 - isDotPressed member variable removed
 - dotClear method removed
 - dotPressed method checking dot using indexOf method of StringBuilder 
 
 in Calculator class:
 - calling display.clearDot() removed in pressedNumber
   
# Current Status at Step 5  
## Code smells to be able to refactor
 - In Calculator class; switch in pressedOperator should be removed
 - In Calculator class; switch in actionPerformed should be removed

## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - refactor switch in actionPerformed
 - refactor Operator enum for this purpose 