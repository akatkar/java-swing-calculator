# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 8 : Refactored calculation  
 - Expression class defined and all calculation moved to this class
 - In Calculator class; operand1, operandCount and previousOperator fields removed
 - Expression field add instead of them
 - if block completely removed in pressedNumber method
 - expression.clear() called in pressedClear() 
 - clearDisplay method removed and display.clear() called in pressedClear() directly
 - display also must be cleared when getValue method called because we removed from pressedNumber
 - added clear() in Display.getValue method  
 - main usage of expression in pressedOperator method. This method now shorter 
   
# Current Status at Step 8  
## Code smells to be able to refactor
 - In Calculator class; if-else block in actionPerformed should be removed
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - in pressedOperator method, Display.hasValue called
 - This behaviour exactly same with Optional
 - refactor this code using Optional instead of checking if value exists
 