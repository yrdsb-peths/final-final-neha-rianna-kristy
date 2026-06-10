import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeParts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeParts extends Actor
{
    public SnakeParts(String picture)
    {

    }
    public void act()
    {
        // Add your action code here.
    }

    public Actor getTouchingApple()
    {
        return getOneObjectAtOffset(0, 0, Apple.class);
    }
}
