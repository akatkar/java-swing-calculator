# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 4 : Refactored displayValue  
In this step, we just moved to displayValue into Display class. 
 - displayValue moved into Display class
 - dotPressed, which is also related with displayValue, moved into Display Class
 - clearDisplay functionality moved into Display class as clear() method
 - we now calls display.clear() in clearDisplay
 - Added dotPressed method in Display class
 - Added clearDot method in Display class
 - in pressedNumber method, called display.clearDot()
 - displayValue.append moved from pressedNumber into Display class as append method
 - in pressedOperator method, checking if display has value moved to Display class as hasValue method
 - in pressedOperator method, reading display value moved to Display class as getValue method
 - in pressedOperator method, setting display value moved to Display class as setValue method (setValue changed)
 - in actionPerformed, case "." changed as display.dotPressed()  

## Next step, for refactoring Display class;
  - No need to hold dotPressed as a variable. We can check it from StringBuilder
  - We can check if value has fraction during setting display text component 
  
# Current Status at Step 4  
## Code smells to be able to refactor
 - In Calculator class; switch in pressedOperator should be removed
 - In Calculator class; switch in actionPerformed should be removed

## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - refactor dot operations in Display class