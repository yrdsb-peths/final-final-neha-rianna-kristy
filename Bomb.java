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
        setImage("bomb.png"); 
        
        GreenfootImage img = getImage();

        img.scale(49, 49);
        setImage(img);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
