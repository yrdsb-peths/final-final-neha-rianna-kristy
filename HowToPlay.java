import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HowToPlay extends Button
{
    public HowToPlay()
    {
        setText("How To Play");
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null && mouse.getActor() == this)
        {
            // hovered
            setImage(new GreenfootImage("How To Play", 70, Color.BLACK,
                                        new Color(0,0,0,0), Color.BLACK));
        }
        else
        {
            // not hovered
            setImage(new GreenfootImage("How To Play", 70, Color.WHITE,
                                        new Color(0,0,0,0), Color.BLACK));
        }
        
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new TutorialPopup(), 500, 375);
        }
    }
}