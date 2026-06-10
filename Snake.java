import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

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
    
    // Sound that plays when you hit a bomb
    private GreenfootSound bombExplodeSound = new GreenfootSound("bomb_explode.mp3");

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
        if (isDead) 
        {
            return; 
        }

        checkKeys();
        counter++;

        if (counter >= moveDelay)
        {
            moveSnake();

            if (checkWallCollision())
            {
                executeGameOver("GAME OVER");
                return;
            }

            if (checkSelfCollision())
            {
                executeGameOver("GAME OVER");
                return;
            }
            
            // CHECK FOR BOMBS HERE DIRECTLY
            checkBombCollision();
            if (isDead) return; 
            
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
            ((EasyGrid)getWorld()).addScore(); 
            getWorld().removeObject(apple);
            growSnake();
            spawnApple();
            
            // Spawn a bomb every time an apple is eaten!
            ((EasyGrid)getWorld()).spawnBomb();
        }
    }

    // SIMPLIFIED BOMB CHECKER: Checks if a bomb is sitting exactly where the head is
    private void checkBombCollision()
    {
        SnakeParts head = parts.get(0);
        
        // Look at the head's exact X and Y position for any Bombs
        List<Bomb> bombs = getWorld().getObjectsAt(head.getX(), head.getY(), Bomb.class);
        
        if (!bombs.isEmpty())
        {
            // Get the bomb we stepped on
            Bomb hitBomb = bombs.get(0);
            
            // Stop music and play explosion!
            ((EasyGrid)getWorld()).stopBackgroundMusic();
            bombExplodeSound.play(); 
            
            // Remove it from the grid
            getWorld().removeObject(hitBomb);
            
            // End the game
            executeGameOver("BOOM! GAME OVER");
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

    private void executeGameOver(String message)
    {
        ((EasyGrid)getWorld()).stopBackgroundMusic();
        if (message.equals("GAME OVER")) {
            gameOverSound.play();
        }
        
        int centerX = getWorld().getWidth() / 2;
        int centerY = getWorld().getHeight() / 2;
        getWorld().showText(message, centerX, centerY);
        isDead = true;
        
    }
    
    public void increaseSpeed()
    {
        if (moveDelay > 2)
        {
            moveDelay--; 
        }
    }
}