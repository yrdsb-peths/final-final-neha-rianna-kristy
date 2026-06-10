import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        addObject(new Snake(true), 90, 110);
    }
}
