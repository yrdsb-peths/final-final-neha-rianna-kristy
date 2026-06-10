import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialPopup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialPopup extends Actor
{
    /**
     * Act - do whatever the TutorialPopup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }
    
    public TutorialPopup()
    {
        GreenfootImage img = new GreenfootImage(700, 400);

        img.setColor(Color.WHITE);
        img.fillRect(0, 0, 700, 400);

        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 699, 399);
        
        img.setFont(new Font("Monospaced", true, false, 60));
        img.drawString("HOW TO PLAY:", 160, 115);
        
        img.setFont(new Font("Monospaced", false, false, 30));
        img.drawString("Use arrow keys to move", 50, 205);
        img.drawString("Eat apples to grow", 50, 255);
        img.drawString("Avoid hitting walls and yourself", 50, 305);
        img.drawString("CLICK TO EXIT", 240, 355);
        
        setImage(img);
    }
}
