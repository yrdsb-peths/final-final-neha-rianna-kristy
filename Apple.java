import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An apple that the snake can eat to grow.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    public Apple()
    {
        GreenfootImage img = new GreenfootImage("apple.png");
        img.scale(60, 60);
        setImage(img);
    }
}
