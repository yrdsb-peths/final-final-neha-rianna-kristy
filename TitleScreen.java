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
        super(900, 700, 1);

        setBackground(new GreenfootImage("background.png"));
        
        HowToPlay instr = new HowToPlay();
        addObject(instr, 450, 500);
        
        prepare();
        
        
        SelectButton select = new SelectButton();
        addObject(select, 450, 600);

    }
    
    public void act()
    {

    }
    
    
    private void prepare()
    {
        addObject(new Logo(), 450, 275);

    }
    
}