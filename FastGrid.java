import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FastGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastGrid extends World
{

    /**
     * Constructor for objects of class FastGrid.
     * 
     */
    public FastGrid()
    {    
        super(436, 436, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);
    }
}
