import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitlePage here.
 * * @author Rianna
 * @version May 2026
 */
public class TitlePage extends World
{
    private HowToPlay howToPlay;
    private EasyButton easyBtn; 
    
    public TitlePage()
    {    
        super(600, 400, 1);
        
        setBackground(new GreenfootImage("backgroundSnake.png"));
        
        prepare();
    }
    
    public void act()
    {
        handleHoverEffects();
        handleClicks();
    }
    
    /**
     * Handles updating button backgrounds when the mouse hovers over them.
     */
    private void handleHoverEffects()
    {
        if (Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null)
            {
                Actor hoveredActor = mouse.getActor();
                
                // Clear highlights by default
                easyBtn.setClearBackground();
                howToPlay.setClearBackground();
                
                // Highlight the specific item being hovered over
                if (hoveredActor == easyBtn) 
                {
                    easyBtn.setWhiteBackground();
                }
                else if (hoveredActor == howToPlay) 
                {
                    howToPlay.setWhiteBackground();
                }
            }
        }
    }
    
    /**
     * Detects clicks on the buttons and switches worlds accordingly.
     */
    private void handleClicks()
    {
        if (Greenfoot.mouseClicked(easyBtn)) 
        {
            // Changes the screen to your easy grid world layout
            Greenfoot.setWorld(new EasyGrid()); 
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // 1. Game Title
        Label titleLabel = new Label("Snake apple", 60);
        addObject(titleLabel, 300, 60);

        // 2. How To Play Headers & Instructions
        Label howToPlayHeader = new Label("How to Play:", 24);
        addObject(howToPlayHeader, 300, 130);
        
        // Using your exact string layout and unicode arrow symbols
        Label instructions1 = new Label("Use Up, Down, Left, and Right keys", 20);
        Label instructions2 = new Label("Use \u2190 \u2191 \u2193 \u2192 to Move", 20);
        addObject(instructions1, 300, 170);
        addObject(instructions2, 300, 200);

        // 3. World Level Selection Button
        easyBtn = new EasyButton(); 
        addObject(easyBtn, 300, 280);

        // 4. Extra Link / Info Button
        howToPlay = new HowToPlay();
        addObject(howToPlay, 300, 340);
        
        // 5. Decorative Snake Picture (placed on the left side)
        SnakeDecoration snakePic = new SnakeDecoration();
        addObject(snakePic, 100, 230); 
    }
}