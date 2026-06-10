import greenfoot.*;

public class PopupButton extends Actor
{
    private String text;
    private Runnable action;

    public PopupButton(String text, Runnable action)
    {
        this.text = text;
        this.action = action;

        updateImage(false);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            action.run();
        }

        if (Greenfoot.mouseMoved(this))
        {
            updateImage(true);
        }

        if (Greenfoot.mouseDragEnded(this))
        {
            updateImage(false);
        }
    }

    private void updateImage(boolean hover)
    {
        Color bg = hover ? Color.BLACK : Color.WHITE;
        Color fg = hover ? Color.WHITE : Color.BLACK;

        GreenfootImage img = new GreenfootImage(220, 60);
        img.setColor(bg);
        img.fillRect(0, 0, 220, 60);

        img.setColor(fg);
        img.setFont(new Font("Monospaced", true, false, 24));
        img.drawString(text, 20, 38);

        setImage(img);
    }
}
