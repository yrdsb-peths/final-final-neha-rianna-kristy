import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClassicButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassicButton extends Button
{
    /**
     * Act - do whatever the ClassicButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

public class ClassicButton extends Button
{
    private boolean hovered = false;

    public ClassicButton()
    {
        setText("CLASSIC");
    }

    public void act()
    {
        if (Greenfoot.mouseMoved(this) || Greenfoot.mouseDragEnded(this))
        {
            setBlack();
        }
        else if (Greenfoot.mouseMoved(null) && !isMouseOver())
        {
            setWhite();
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ClassicGrid());
        }
    }

    private boolean isMouseOver()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        return mouse != null && mouse.getActor() == this;
    }

    private void setBlack()
    {
        GreenfootImage img = new GreenfootImage("CLASSIC", 40, Color.BLACK, new Color(0,0,0,0));
        setImage(img);
    }

    private void setWhite()
    {
        GreenfootImage img = new GreenfootImage("CLASSIC", 40, Color.WHITE, new Color(0,0,0,0));
        setImage(img);
    }
}
⚡ Even simpler version (recommended)

This is cleaner and works every frame:

public void act()
{
    MouseInfo mouse = Greenfoot.getMouseInfo();

    if (mouse != null && mouse.getActor() == this)
    {
        setImage(new GreenfootImage("CLASSIC", 40, Color.BLACK, new Color(0,0,0,0)));
    }
    else
    {
        setImage(new GreenfootImage("CLASSIC", 40, Color.WHITE, new Color(0,0,0,0)));
    }

    if (Greenfoot.mouseClicked(this))
    {
        Greenfoot.setWorld(new ClassicGrid());
    }
}
🎯 Do the same for all buttons

Just change the text:

"CLASSIC"
"BOMBS"
"FAST"
"REVERSE"
💡 Important tip

If your buttons are already black background, use:

WHITE = normal
BLACK = hover

or swap them depending on your design.

👍 If you want next level UI

I can help you make:

smooth fade hover (not instant change)
button scaling animation
glowing selection effect
sound effects on hover/click

Just say 👍
}
