import greenfoot.*;

public class EndPopup extends Actor
{
    private String message;
    private BaseGrid previousWorld;

    public EndPopup(String message, BaseGrid previousWorld)
    {
        int popupWidth = previousWorld.getWidth() * 2 / 3;
        int popupHeight = previousWorld.getHeight() * 2 / 3;

        GreenfootImage img = new GreenfootImage(popupWidth, popupHeight);

        img.setColor(new Color(0, 0, 0, 200));
        img.fillRect(0, 0, 700, 500);

        img.setColor(Color.WHITE);
        img.setFont(new Font("Monospaced", true, false, 50));
        img.drawString(message, 120, 120);

        setImage(img);
    }

    public void addedToWorld(World world)
    {
        int cx = world.getWidth() / 2;
        int cy = world.getHeight() / 2;

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