import greenfoot.*;

public class EndPopup extends Actor
{
    private String message;
    private BaseGrid previousWorld;

    public EndPopup(String message, BaseGrid previousWorld)
    {
        this.previousWorld = previousWorld;
        this.message = message;
        
        int popupWidth;
        int popupHeight;
    
        if (previousWorld instanceof SmallGrid)
        {
            popupWidth = 250;
            popupHeight = 180;
        }
        else
        {
            popupWidth = previousWorld.getWidth() * 2 / 3;
            popupHeight = previousWorld.getHeight() * 2 / 3;
        }

        GreenfootImage img = new GreenfootImage(popupWidth, popupHeight);

        img.setColor(new Color(0, 0, 0, 200));
        img.fillRect(0, 0, popupWidth, popupHeight);

        int fontSize;

        if (previousWorld instanceof SmallGrid)
        {
            fontSize = 25;
        }
        else
        {
            fontSize = 50;
        }
        
        img.setColor(Color.WHITE);
        img.setFont(new Font("Monospaced", true, false, fontSize));
        
        if (previousWorld instanceof SmallGrid)
        {
            img.drawString(message, 60, 60);
        }
        else if (previousWorld instanceof MegaGrid)
        {
            img.drawString(message, 140, 140);
        }
        else
        {
            img.drawString(message, 105, 120);
        }

        setImage(img);
    }

    public void addedToWorld(World world)
    {
        int cx = world.getWidth() / 2;
        int cy = world.getHeight() / 2;
        if (world instanceof SmallGrid)
        {
            world.addObject(new PopupButton("RESTART", new Runnable() {
            public void run()
            {
                
                if (previousWorld instanceof ClassicGrid)
                {
                    Greenfoot.setWorld(new ClassicGrid());
                }
                else if (previousWorld instanceof BombGrid)
                {
                    Greenfoot.setWorld(new BombGrid());
                }
                else if (previousWorld instanceof FastGrid)
                {
                    Greenfoot.setWorld(new FastGrid());
                }
                else if (previousWorld instanceof ReverseGrid)
                {
                    Greenfoot.setWorld(new ReverseGrid());
                }
                else if (previousWorld instanceof MegaGrid)
                {
                    Greenfoot.setWorld(new MegaGrid());
                }
                else if (previousWorld instanceof SmallGrid)
                {
                    Greenfoot.setWorld(new SmallGrid());
                }
            }
            }), cx, cy + 20);
        
            world.addObject(new PopupButton("MENU", new Runnable() {
                public void run()
                {
                    Greenfoot.setWorld(new TitleScreen());
                }
            }), cx, cy + 60);
        }
        else
        {
            world.addObject(new PopupButton("RESTART", new Runnable() {
                public void run()
                {
                    
                    if (previousWorld instanceof ClassicGrid)
                    {
                        Greenfoot.setWorld(new ClassicGrid());
                    }
                    else if (previousWorld instanceof BombGrid)
                    {
                        Greenfoot.setWorld(new BombGrid());
                    }
                    else if (previousWorld instanceof FastGrid)
                    {
                        Greenfoot.setWorld(new FastGrid());
                    }
                    else if (previousWorld instanceof ReverseGrid)
                    {
                        Greenfoot.setWorld(new ReverseGrid());
                    }
                    else if (previousWorld instanceof MegaGrid)
                    {
                        Greenfoot.setWorld(new MegaGrid());
                    }
                    else if (previousWorld instanceof SmallGrid)
                    {
                        Greenfoot.setWorld(new SmallGrid());
                    }
                }
            }), cx, cy + 60);
            
            world.addObject(new PopupButton("MENU", new Runnable() {
                public void run()
                {
                    Greenfoot.setWorld(new TitleScreen());
                }
            }), cx, cy + 140);
        }
    }
}