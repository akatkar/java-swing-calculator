# Calculator
 
This is the Swing GUI demonstration code.  

Code will be improved step by step. 

# STEP 13 : Refactored if block - removed completely  
 - To be able to remove if block we need to know a key with caption and action at same time
 - We can achieve this purpose using enum 
 - We defined an enum called KeyType and its constructor accepts caption and action as BiConsumer
 - KeyMap rewritten with KeyType enum (added a static import to be able use names directly)
 - Constructor of KeyButton class changed to accept KeyType
 - Now we can create all Keys without need an if block
 - initComponents changed to create Keys according to KeyButton constructor
 - No need DIGIT and OPERATORS patterns now, they are deleted    
  
# Current Status at Step 13  
## Code smells to be able to refactor
 - NONE
 
## New features to be able to add
 - The keys ".", "M+", "M-" and "%" are not working. 

## Bugs to be able to fix
 - GUI Fonts can be changed
 - GUI should not be enlarged, resize must be prevented 
   
# What can be done in next step?
  - In Keypad class, for loop removed using functional approach