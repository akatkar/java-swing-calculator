# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 9 : Refactored Display getValue with Optional returns  
 - in Display class, hasValue became private
 - in Display class, getValue changed as return Optional<Double>
 - in Expression class, changed calculate methods to be able to accept Optional
 - in Expression class, The method calculate(Operator,double) became private
 - in Calculator class, changed pressedOperator
 
 
# Current Status at Step 9  
## Code smells to be able to refactor
 - In Calculator class; if-else block in actionPerformed should be removed
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - This Optional usage added new problem
 - Every getValue calls create a Double object because we have primitive double
 - This object creation is actually unnecessary 
 - Java8 defined for Optionals for primitive as well for better performance
 - So we can refactor Optional<Double> with OptionalDouble to increase performance