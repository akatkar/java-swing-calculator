# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 11 : Refactored if-block with Command Design Pattern  
 - Command interface defined
 - In KeyPad class, Key classes which implements Command defined like DotKey, NumberKey etc
 - Execute methods calls Calculator methods like pressedNumber, so private modifiers removed from  these methods
 - In Calculator class we add a new method as pressedDot
 - DIGIT and OPERATORS patterns moved from Calculator to Keypad
 - In KeyPad class, Key objects created and added to panel initComponents method
 - Now we can use Command execute method in actionPerformed method in Calculator class  
 
 
# Current Status at Step 11  
## Code smells to be able to refactor
 - In Calculator class; if-else block in actionPerformed should be removed
 - As you can see, the if block transferred from Calculator to KeyPad class
 - Key classes creates verbosity in KeyPad Class
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
 - Declaring class for each type of Key creates verbosity
 - So we can declare a class and inject behaviour during creating object
 - This dependency injection can be performed with using FunctionalInterface  
 - Let's remove this verbosity
 