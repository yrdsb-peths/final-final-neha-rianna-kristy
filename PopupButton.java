import greenfoot.*;

public class PopupButton extends Actor
{
    private String text;
    private Runnable action;

    public PopupButton(String text, Runnable action)
    {
        this.text = text;
        this.action = action;
    }

    public void addedToWorld(World world)
    {
        updateImage();
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            action.run();
        }
    }

    private void updateImage()
    {
        int buttonWidth = getWorld().getWidth() / 4;
        int buttonHeight = getWorld().getHeight() / 12;

        GreenfootImage img = new GreenfootImage(buttonWidth, buttonHeight);

        img.setColor(Color.WHITE);
        img.fillRect(0, 0, buttonWidth, buttonHeight);

        img.setColor(Color.BLACK);
        img.drawRect(0, 0, buttonWidth - 1, buttonHeight - 1);

        img.setFont(new Font("Monospaced", true, false, buttonHeight / 2));
        img.drawString(text, buttonWidth / 8, buttonHeight * 2 / 3);

        setImage(img);
    }
}
