import greenfoot.*;

public class EndPopup extends Actor
{
    private String message;

    public EndPopup(String message)
    {
        this.message = message;

        GreenfootImage img = new GreenfootImage(700, 500);

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

        // RESTART BUTTON
        world.addObject(new PopupButton("RESTART", new Runnable() {
            public void run()
            {
                Greenfoot.setWorld(new BaseGrid(1000, 824));
            }
        }), cx, cy + 60);

        // MENU BUTTON
        world.addObject(new PopupButton("MENU", new Runnable() {
            public void run()
            {
                Greenfoot.setWorld(new TitleScreen());
            }
        }), cx, cy + 140);
    }
}