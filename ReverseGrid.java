import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReverseGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseGrid extends World
{

    /**
     * Constructor for objects of class ReverseGrid.
     * 
     */
    public ReverseGrid()
    {    
        super(436, 436, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110); 
    }
}
