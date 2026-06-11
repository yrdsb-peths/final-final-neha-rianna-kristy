import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Rianna, Kristy, Neha
 * @version May 2026
 */
public class TitleScreen extends World
{
    /**
     * Constructor for the title screen, sets background and adds how to play
     * and selector
     */
    public TitleScreen()
    {    
        super(900, 700, 1);
        
        GreenfootImage bg = new GreenfootImage("background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        HowToPlay instr = new HowToPlay();
        addObject(instr, 450, 500);
        
        prepare();
        
        SelectButton select = new SelectButton();
        addObject(select, 450, 600);

    }
        
    private void prepare()
    {
        addObject(new Logo(), 450, 275);
    }
    
}