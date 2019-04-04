# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 2 : Refactor accessibility  
 - Display class and KeyPad classes accessibility changed to default(package)
 - In MainClass, Anonymous inner class changed to lambda 
  
# Current Status at Step 2  
## Code smells to be able to refactor
 - In MainClass, Constructor reference can be used in lambda 
 - In Calculator class; switch in pressedOperator should be removed
 - In Calculator class; switch in actionPerformed should be removed
 - In Calculator class; displayValue should be in Display Class 

## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - In MainClass, Constructor reference can be used in lambda, so let's do it
