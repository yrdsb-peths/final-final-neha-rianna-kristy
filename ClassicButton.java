import greenfoot.*;
import java.awt.Font;

public class ClassicButton extends Button
{
    private boolean hovered = false;

    public ClassicButton()
    {
        setText("Classic");
    }

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
}
  