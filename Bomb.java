import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (Rianna) 
 * @version (June 2026)
 */
public class Bomb extends Actor
{
    public Bomb()
    {
        GreenfootImage img = getImage();
        
        
        int randomSize = Greenfoot.getRandomNumber(16) + 10; 
        
        img.scale(randomSize, randomSize);
        
        setImage(img);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
