import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ReverseGrid extends BaseGrid
{

    /**
     * Constructor for objects of class ReverseGrid.
     * 
     */
    public ReverseGrid()
    {    
        super(436, 436);
        addObject(new Snake(true), 90, 110);
    }
}
