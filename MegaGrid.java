import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MegaGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MegaGrid extends BaseGrid
{

    /**
     * Constructor for objects of class MegaGrid.
     * 
     */
    public MegaGrid()
    {    
        super(1600, 1318);
        
        addObject(new Snake(false), 90, 110);
        mode = "mega";
    }
}
