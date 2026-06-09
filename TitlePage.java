import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Rianna, Kristy, Neha
 * @version May 2026
 */
public class TitlePage extends World
{
    private HowToPlay howToPlay;
    private EasyButton easyBtn; 
    
    public TitlePage()
    {    
        super(1000, 750, 1);

        setBackground(new GreenfootImage("background.png"));
        
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
        addObject(new Logo(), 500, 275);

        // How To Play Headers & Instructions
        Label howToPlayHeader = new Label("How to Play:", 24);
        addObject(howToPlayHeader, 300, 130);
        
        Label instructions2 = new Label("Use \u2190 \u2191 \u2193 \u2192 to Move", 20);
        addObject(instructions2, 300, 200);

        howToPlay = new HowToPlay();
        addObject(howToPlay, 300, 340);
        

        
        
 
    }
    
}