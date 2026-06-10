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
        super(831, 743);
        
        addObject(new Snake(false), 418, 374);
    }
}
