# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 1 : Finding Code Smells, new features  
## Code smells to be able to refactor
 - In MainClass, anonymous inner class can be changed to lambda 
 - Display and Keypad classes should be default access
 - All public methods in these class should be default as well
 - In Calculator class; switch in pressedOperator should be removed
 - In Calculator class; switch in actionPerformed should be removed
 - In Calculator class; displayValue should be in Display Class 

## New features to be able to add
 - The keys "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - First three code smells can be fixed easily; 
 - MainClass will be changed to lambda 
 - Access modifiers will be changed for Display and Keypad classes
  