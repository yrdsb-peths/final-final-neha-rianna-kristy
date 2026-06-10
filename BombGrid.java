import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombGrid extends BaseGrid
{

    /**
     * Constructor for objects of class BombGrid.
     * 
     */
    public BombGrid()
    {    
        addObject(new Snake(false), 90, 110);
    }
}
