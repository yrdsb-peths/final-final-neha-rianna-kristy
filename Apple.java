import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An apple that the snake can eat to grow.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class Apple extends Actor
{
    /**
     * Constructor for apple, assigns image and scales it
     */
    public Apple()
    {
        GreenfootImage img = new GreenfootImage("apple.png");
        img.scale(49, 49);
        setImage(img);
    }
}
