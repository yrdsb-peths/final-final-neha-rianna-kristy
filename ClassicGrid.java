import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClassicGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassicGrid extends BaseGrid
{

    /**
     * Constructor for objects of class ClassicGrid.
     * 
     */
    public ClassicGrid()
    {    
        addObject(new Snake(false), 90, 110);
    }
}
