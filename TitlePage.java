import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Rianna, Kristy, Neha
 * @version May 2026
 */
public class TitlePage extends World
{
    public TitlePage()
    {    
        super(1000, 750, 1);

        setBackground(new GreenfootImage("background.png"));
        
        HowToPlay instr = new HowToPlay();
        addObject(instr, 500, 550);
        
        prepare();
        
        
        SelectButton select = new SelectButton();
        addObject(select, 500, 650);

    }
    
    public void act()
    {

    }
    
    /**
     * Handles updating button backgrounds when the mouse hovers over them.
     */
    
    
    private void prepare()
    {
        
        
        // Game Logo
        addObject(new Logo(), 500, 275);

    }
    
}