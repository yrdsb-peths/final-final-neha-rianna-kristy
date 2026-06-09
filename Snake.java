import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Snake here.
 * * @author (Neha, Rianna) 
 * @version (June 2026)
 */
public class Snake extends Actor
{
    private int gridSize = EasyGrid.GRID_SIZE;

    private ArrayList<SnakeParts> parts = new ArrayList<SnakeParts>();

    private int xSpeed = -gridSize;
    private int ySpeed = 0;

    private int counter = 0;
    private int moveDelay = 10;
    
    private boolean isDead = false;

    private GreenfootSound eatSound = new GreenfootSound("eat_apple.wav");
    private GreenfootSound gameOverSound = new GreenfootSound("game_over.wav"); 

    public Snake()
    {
        setImage(new GreenfootImage(1,1));
    }

    public void addedToWorld(World world)
    {
        SnakeParts head = new SnakeParts("head0.png");
        SnakeParts body = new SnakeParts("middle.png");
        SnakeParts tail = new SnakeParts("tail.png");

        parts.add(head);
        parts.add(body);
        parts.add(tail);

        world.addObject(head, getX(), getY());
        world.addObject(body, getX() + gridSize, getY());
        world.addObject(tail, getX() + gridSize * 2, getY());
        spawnApple();
    }

    public void act()
    {
        // If we flagged a death last frame, freeze all gameplay actions
        if (isDead) 
        {
            return; 
        }

        checkKeys();
        counter++;

        if (counter >= moveDelay)
        {
            // 1. Move the snake FIRST
            moveSnake();

            // 2. NOW check if that movement put the snake out of bounds!
            if (checkWallCollision())
            {
                // Tell EasyGrid to turn off the background music and freeze the timer
                ((EasyGrid)getWorld()).stopBackgroundMusic();
                
                gameOverSound.play(); // Play game over music
                
                // Draw text right in the middle
                int centerX = getWorld().getWidth() / 2;
                int centerY = getWorld().getHeight() / 2;
                getWorld().showText("GAME OVER", centerX, centerY);
                
                isDead = true; // Turn on the death flag
                return;
            }

            // 3. Check if it hit itself
            if (checkSelfCollision())
            {
                // Tell EasyGrid to turn off the background music and freeze the timer here too
                ((EasyGrid)getWorld()).stopBackgroundMusic();
                
                gameOverSound.play();
                
                int centerX = getWorld().getWidth() / 2;
                int centerY = getWorld().getHeight() / 2;
                getWorld().showText("GAME OVER", centerX, centerY);
                
                isDead = true;
                return;
            }
            
            checkApple();
            counter = 0;
        }
    }
    
    private void moveSnake()
    {
        for (int i = parts.size() - 1; i > 0; i--)
        {
            SnakeParts current = parts.get(i);
            SnakeParts inFront = parts.get(i - 1);
    
            current.setLocation(inFront.getX(), inFront.getY());
        }

        SnakeParts head = parts.get(0);
        head.setLocation(head.getX() + xSpeed, head.getY() + ySpeed);
    }
    
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("up") && ySpeed == 0)
        {
            xSpeed = 0;
            ySpeed = -gridSize;
        }
        else if (Greenfoot.isKeyDown("down") && ySpeed == 0)
        {
            xSpeed = 0;
            ySpeed = gridSize;
        }
        else if (Greenfoot.isKeyDown("left") && xSpeed == 0)
        {
            xSpeed = -gridSize;
            ySpeed = 0;
        }
        else if (Greenfoot.isKeyDown("right") && xSpeed == 0)
        {
            xSpeed = gridSize;
            ySpeed = 0;
        }
    }
    
    private void spawnApple()
    {
        int numCols = getWorld().getWidth() / gridSize;
        int numRows = getWorld().getHeight() / gridSize;
    
        int col = Greenfoot.getRandomNumber(numCols);
        int row = Greenfoot.getRandomNumber(numRows);
    
        int x = col * gridSize + gridSize / 2;
        int y = row * gridSize + gridSize / 2;
    
        getWorld().addObject(new Apple(), x, y);        
    }
    
    private void checkApple()
    {
        SnakeParts head = parts.get(0);
        Actor apple = head.getTouchingApple();
    
        if (apple != null)
        {
            eatSound.play(); 
            
            // FIX: Changed to (EasyGrid) so the score connects to your actual scoreboard!
            ((EasyGrid)getWorld()).addScore(); 
            
            getWorld().removeObject(apple);
            growSnake();
            spawnApple();
        }
    }

    private void growSnake()
    {
        SnakeParts tail = parts.get(parts.size() - 1);
        SnakeParts newPart = new SnakeParts("middle.png");
        parts.add(newPart);
        getWorld().addObject(newPart, tail.getX(), tail.getY());
    }
    
    private boolean checkWallCollision()
    {
        SnakeParts head = parts.get(0);
        return head.getX() < 0 || head.getX() >= getWorld().getWidth() || head.getY() < 0 || head.getY() >= getWorld().getHeight();
    }
    
    private boolean checkSelfCollision()
    {
        SnakeParts head = parts.get(0);
        for (int i = 1; i < parts.size(); i++)
        {
            SnakeParts part = parts.get(i);
            if (head.getX() == part.getX() && head.getY() == part.getY())
            {
                return true;
            }
        }
        return false;
    }
}