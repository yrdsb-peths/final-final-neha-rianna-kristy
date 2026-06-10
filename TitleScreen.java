import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Rianna, Kristy, Neha
 * @version May 2026
 */
public class TitleScreen extends World
{
    public TitleScreen()
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
    
    
    private void prepare()
    {
        addObject(new Logo(), 500, 275);

    }
    
}