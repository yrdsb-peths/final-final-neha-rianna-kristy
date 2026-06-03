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
        MouseInfo mouse = Greenfoot.getMouseInfo();
        easyBtn.setClearBackground();
        howToPlay.setClearBackground();
        if (mouse == null)
        {
            return;
        }
        if (mouse != null)
        {
            Actor actor = mouse.getActor();
            
            if (actor == easyBtn)
            {
                easyBtn.setWhiteBackground();
            }
            else if (actor == howToPlay)
            {
                howToPlay.setWhiteBackground();
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
            Greenfoot.setWorld(new EasyGrid()); 
        }
        
        if(Greenfoot.mouseClicked(howToPlay))
        {
            
        }
    }
    
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