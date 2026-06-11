import greenfoot.*;
/**
 * A button that starts the Classic game mode.
 * When clicked, the player is taken to the ClassicGrid world.
 * 
 * @author Kristy
 * @version June 2026
 */
public class ClassicButton extends Button
{
    private String text = "Classic";

    /**
     * Creates a ClassicButton and displays its text.
     */
    public ClassicButton()
    {
        updateImage();
    }

    /**
     * Checks for mouse clicks and starts the Classic game mode.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ClassicGrid());
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