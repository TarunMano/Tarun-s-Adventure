# Word Adventure

### **DESCRIPTION**
Word Adventure is our [FBLA (Future Business Leaders of America)](https://www.fbla-pbl.org/) entry for the Computer Game & Simulation Programming event. The 2022 NLC Topic is as follows:
> In 2022, Wordle and similar word games were all the rage across the world. Develop a word game with rules and a theme of your choice.  
  • The game should be an executable game, either through the Internet or
  through a local installation (review guidelines about Internet access at the
  National Leadership Conference).  
  • The game should contain a scoreboard.  
  • The game should contain a leaderboard and celebratory messages.  
  • The game should have a minimum of three levels.  
  • The game should have an instructional display.  

This application allows the user to explore a 2D map to search for the correct letters to a given word.

### **FEATURES**
2D based Java game
  - Collect letters
  - Try to beat speed records
  - Tutorial when starting game
  - Intuitive user interface/navigation
  - Clean retro theme (visual graphics/sound)
  - User friendly controls
  
    **WASD or Arrow Keys to move**
    
     **ESC to pause**

### **TECHNOLOGIES & FRAMEWORKS**
- **Java (awt graphics)**
    - The Graphics class is the abstract base class for all graphics contexts that allow an application to draw onto components that are realized on various devices, as well as onto off-screen images.

    - A Graphics object encapsulates state information needed for the basic rendering operations that Java supports. This state information includes the following properties: 
        - The Component object on which to draw.
        - A translation origin for rendering and clipping coordinates.
        - The current clip.
        - The current color.
        - The current font.
        - The current logical pixel operation function (XOR or Paint).
        - The current XOR alternation color (see setXORMode(java.awt.Color)). 

    - Coordinates are infinitely thin and lie between the pixels of the output device. Operations that draw the outline of a figure operate by traversing an infinitely thin path between pixels with a pixel-sized pen that hangs down and to the right of the anchor point on the path. Operations that fill a figure operate by filling the interior of that infinitely thin path. Operations that render horizontal text render the ascending portion of character glyphs entirely above the baseline coordinate. 

    - All coordinates that appear as arguments to the methods of this Graphics object are considered relative to the translation origin of this Graphics object prior to the invocation of the method.

    - All rendering operations modify only pixels which lie within the area bounded by the current clip, which is specified by a Shape in user space and is controlled by the program using the Graphics object. This user clip is transformed into device space and combined with the device clip, which is defined by the visibility of windows and device extents. The combination of the user clip and device clip defines the composite clip, which determines the final clipping region. The user clip cannot be modified by the rendering system to reflect the resulting composite clip. The user clip can only be changed through the setClip or clipRect methods. All drawing or writing is done in the current color, using the current paint mode, and in the current font.

- **FileIO (Scanner)**
    - The Scanner class is used to get user input, and it is found in the java.util package.

    - The Scanner class is implemented here to get a random word from a given word list called dictionary.txt. Changing this file will change the possible words that can be the objective of the game.
