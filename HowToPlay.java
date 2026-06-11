import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * A button that opensthe HowToPlayPopup.
 * When clicked, the player is taken to the ClassicGrid world.
 * 
 * @author Kristy
 * @version June 2026
 */
public class HowToPlay extends Button
{
    /**
     * Creates a HowToPlay button and sets its text
     */
    public HowToPlay()
    {
        setText("HOW TO PLAY");
    }
    
    /**
     * Runs continuously while title screen is open
     * Changes the button to black font when mouse is hovered
     * Opens TutorialPopup when clicked
     */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null && mouse.getActor() == this)
        {
            // hovered
            setImage(new GreenfootImage("HOW TO PLAY", 50, Color.BLACK, new Color(0,0,0,0), Color.BLACK));
        }
        else
        {
            // not hovered
            setImage(new GreenfootImage("HOW TO PLAY", 50, Color.WHITE, new Color(0,0,0,0), Color.BLACK));
        }
        
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new TutorialPopup(), 450, 375);
        }
    }
}