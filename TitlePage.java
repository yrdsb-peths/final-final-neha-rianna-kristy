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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 300, 1);
        
        // Set your custom background image
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
                
                easyBtn.setClearBackground();
                howToPlay.setClearBackground();
                
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
        // Game Title
        Label titleLabel = new Label("Sssnack Attack", 60);
        addObject(titleLabel, 300, 60);

        // How To Play Headers & Instructions
        Label howToPlayHeader = new Label("How to Play:", 24);
        addObject(howToPlayHeader, 300, 130);
        
        Label instructions2 = new Label("Use \u2190 \u2191 \u2193 \u2192 to Move", 20);
        addObject(instructions2, 300, 200);

        easyBtn = new EasyButton(); 
        addObject(easyBtn, 300, 280);

        howToPlay = new HowToPlay();
        addObject(howToPlay, 300, 340);
        
 
    }
}