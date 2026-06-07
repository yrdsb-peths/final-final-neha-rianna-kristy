import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyGrid extends World
{

    /**
     * Constructor for objects of class EasyGrid.
     * 
     */
    public EasyGrid()
    {    
        super(600, 400, 1); 
        addObject(new Snake(), 300, 300);
    }
}
