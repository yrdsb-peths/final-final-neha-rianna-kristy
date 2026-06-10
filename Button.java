import greenfoot.*;
import java.awt.Font;

public class Button extends Actor
{
    protected String text;
    private GreenfootImage image;

    public void setText(String text)
    {
        this.text = text;
        draw(Color.WHITE);
    }

    public void setHover(boolean hover)
    {
        if (hover)
        {
            draw(Color.BLACK);
        }
        else
        {
            draw(Color.WHITE);
        }
    }

    private void draw(Color textColor)
    {
        if (text == null) return;

        image = new GreenfootImage(text, 60, textColor, new Color(0,0,0,0));
        image.setFont(new Font("Monospaced", true, false, 30));

        setImage(image);
    }
}
