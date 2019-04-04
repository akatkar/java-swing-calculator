# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 10 : Refactor Optional from Display.getValue()  
 Optional<T> is used for Objects so primitives turns to Object to be able to use it
 So many unnecessary objects are created for this purpose
 OptionalDouble, for our case, is more suitable to prevent these unnecessary object creation
 - So "Optional<Double>" changed to "OptionalDouble" as return value in Display.getValue method
 - In Expression class, we have to change calculate method as well to be able to accept OptionalDouble instead of Optional<Double> 
 
 Performance has been increased now
 
 
# Current Status at Step 10  
## Code smells to be able to refactor
 - In Calculator class; if-else block in actionPerformed should be removed
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
  - Now we can remove if block from actionPerformed in Calculator class 
  - We will apply Command Pattern to be able to remove this if block