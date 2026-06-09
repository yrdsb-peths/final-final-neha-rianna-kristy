import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HowToPlay extends Button
{
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(new GreenfootImage("How to Play", 60, Color.BLACK, new Color(0,0,0,0)));
        }
        else if (Greenfoot.mouseMoved(null) && !isMouseOver())
        {
            setImage(new GreenfootImage("How to Play", 60, Color.WHITE, new Color(0,0,0,0)));
        }
    }

    private boolean isMouseOver()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse == null)
            return false;

        return mouse.getActor() == this;
    }
}
