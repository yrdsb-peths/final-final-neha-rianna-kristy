import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Logo
 * 
 * @author Kristy
 * @version June 2026
 */
public class Logo extends Actor
{
    /**
     * Act - do whatever the logo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Logo()
    {
        GreenfootImage logo = new GreenfootImage("sssnackattack.png");
        logo.scale(400, 400);
        setImage(logo);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
