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
        addObject(instr, 500, 600);
        
        prepare();
        
        
        ClassicButton classic = new ClassicButton();
        addObject(classic, 500, 250);
        
        BombsButton bombs = new BombsButton();
        addObject(bombs, 500, 350);

        FastButton fast = new FastButton();
        addObject(fast, 500, 450);

        ReverseButton reverse = new ReverseButton();
        addObject(reverse, 500, 550);
        
        MegaButton mega = new MegaButton();
        addObject(reverse, 500, 650);

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