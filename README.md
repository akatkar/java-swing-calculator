# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 7 : Refactored switch in calculate (pressedOperator)  
 - DoubleBinaryOperator added into Operator enum as final field
 - We had to add constructor of enum as well
 - Now we had to add lambda for each instance of enum
 - We add an apply method to be able to call lambda methods
 - In Calculator class, Now we don't need calculate method, so removed (switch removed)
 - In pressedOperator, we called operator.apply method to be able to calculate
      
# Current Status at Step 7  
## Code smells to be able to refactor
 - In Calculator class; if-else block in actionPerformed should be removed
 - All calculation logic can be extracted into a class
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - refactor calculation logic
 - Calculation can be performed in a separate class