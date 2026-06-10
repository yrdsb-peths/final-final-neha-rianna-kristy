import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MegaGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MegaGrid extends World
{

    /**
     * Constructor for objects of class MegaGrid.
     * 
     */
    public MegaGrid()
    {    
        super(654, 654, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);
    }
}
