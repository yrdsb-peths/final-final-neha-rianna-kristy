import greenfoot.*;
/**
 * A button that starts the Fast game mode.
 * When clicked, the player is taken to the FastGrid world.
 * 
 * @author Kristy
 * @version June 2026
 */
public class FastButton extends Button
{
    private String text = "Fast";

    /**
     * Creates a FastButton and displays its text.
     */
    public FastButton()
    {
        updateImage();
    }

    /**
     * Checks for mouse clicks and starts the Fast game mode.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new FastGrid());
        }
    }

    /**
     * Creates and displays the button image.
     */
    private void updateImage()
    {
        GreenfootImage textImg = new GreenfootImage(text, 60, Color.BLACK, new Color(0,0,0,0));
        textImg.setFont(new Font("Monospaced", true, false, 30));

        setImage(textImg);
    }
}
