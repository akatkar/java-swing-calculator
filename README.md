# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 12 : Refactored verbosity which created at previous step  
 In Calculator class, all pressed methods must be similar signature
   So we can use generic lambda for them 
  - The parameter of pressedOperator changed to String 
  - String parameter added to pressedDot and pressedClear methods even if never used
  
 In Display Class,
  - We defined a KeyButton class which constructs with caption and BiConsumer as action
  - BiConsumer<Calculator, String> can be used Calculator method's reference like Calculator::pressedNumber
  - But we had to pressedEmpty method into Calculator class for unused Keys, so added into Calculator class
  - KeyButton class has a getKey method which returns a Key with action according to its caption
  - if block moved to getKey method
 
# Current Status at Step 12  
## Code smells to be able to refactor
 - The if block now transferred to Keypad.KeyButton.getKey method, it should be removed 
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
- if-block can be removed completely
- if block is using to be able to define both caption and behaviour
- This definition can be performed by an enum
- So we can define an enum called Key like Operator and each key knows both its action and caption
- We can create KeyButton instances with this enum values without using if 
 