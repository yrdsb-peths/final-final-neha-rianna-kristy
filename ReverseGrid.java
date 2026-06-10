import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ReverseGrid extends BaseGrid
{

    /**
     * Constructor for objects of class ReverseGrid.
     * 
     */
    public ReverseGrid()
    {    
        super(700, 612);
        addObject(new Snake(true), 90, 110);
        mode = "reverse";
    }
}
