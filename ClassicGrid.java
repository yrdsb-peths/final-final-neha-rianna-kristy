import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClassicGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassicGrid extends World
{

    /**
     * Constructor for objects of class ClassicGrid.
     * 
     */
    public ClassicGrid()
    {    
        super(436, 436, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);

    }
}
