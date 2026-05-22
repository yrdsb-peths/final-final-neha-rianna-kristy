import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Count down, when timer hits 0, end game
 * 
 * @author (Rianna) 
 * @version (May 2026)
 */
public class Timer extends Actor
{
    private int timer = 3600;
    public void act()
    {
        if (timer > 0) 
        {
            timer--;
            getWorld().showText("Time: " + (timer / 60), 50, 50); 
        } 
        else 
        {
            Greenfoot.stop();
        }
    }
}
