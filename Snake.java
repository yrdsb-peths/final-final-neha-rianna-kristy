import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Snake extends Actor
{
    private int gridSize = BaseGrid.GRID_SIZE;
    private ArrayList<SnakeParts> parts = new ArrayList<SnakeParts>();

    private int xSpeed = 0;
    private int ySpeed = 0;
    private boolean isStarted = false;
    private boolean isFirstApple = true;

    private int counter = 0;
    private int moveDelay = 10;
    private boolean isDead = false;

    private GreenfootSound eatSound = new GreenfootSound("eat_apple.wav");
    private GreenfootSound gameOverSound = new GreenfootSound("game_over.wav"); 
    
    private GreenfootSound bombExplodeSound = new GreenfootSound("bomb_explode.mp3");
    
    private boolean reverseControls;
    
    /**
     * Sets if the controls should be reversed
     * 
     * @param reverseControls Boolean of if the controls are reversed or not
     */
    public Snake(boolean reverseControls)
    {
        setImage(new GreenfootImage(1,1));
        this.reverseControls = reverseControls;
    }

    /**
     * Adds the inital body of the snake and the apple to the world
     * 
     * @param world The world the snake is added to
     */
    public void addedToWorld(World world)
    {
        
        SnakeHead head = new SnakeHead();
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

    /**
     * Checks for collisions, runs apple checks and movement
     */
    public void act()
    {
        if (isDead) 
        {
            return; 
        }

        checkKeys();
        counter++;

        if (counter >= moveDelay && isStarted)
        {
            moveSnake();

            if (checkWallCollision())
            {
                executeGameOver("GAME OVER\nScore: " + ((BaseGrid)getWorld()).score);
                return;
            }

            if (checkSelfCollision())
            {
                executeGameOver("GAME OVER\nScore: " + ((BaseGrid)getWorld()).score);
                return;
            }
            
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
            
            int xMove = inFront.getX() - current.getX();
            int yMove = inFront.getY() - current.getY();
            
            current.setLocation(inFront.getX(), inFront.getY());
            rotatePart(current, xMove, yMove);
        }

        SnakeParts head = parts.get(0);
        head.setLocation(head.getX() + xSpeed, head.getY() + ySpeed);
        rotatePart(head, xSpeed, ySpeed);
    }
    
    private void checkKeys()
    {
        if (!reverseControls)
        {
            if (Greenfoot.isKeyDown("up") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = -gridSize;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("down") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = gridSize;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("left") && xSpeed == 0)
            {
                xSpeed = -gridSize;
                ySpeed = 0;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("right") && xSpeed == 0)
            {
                xSpeed = gridSize;
                ySpeed = 0;
                isStarted = true;
            }
        }
        else
        {
            // Reversed controls
            if (Greenfoot.isKeyDown("up") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = gridSize;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("down") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = -gridSize;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("left") && xSpeed == 0)
            {
                xSpeed = gridSize;
                ySpeed = 0;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("right") && xSpeed == 0)
            {
                xSpeed = -gridSize;
                ySpeed = 0;
                isStarted = true;
            }
        }
    }
    
    private void spawnApple()
    {
        if(isFirstApple)
        {
            if (getWorld() instanceof MegaGrid)
            {
                getWorld().addObject(new Apple(), 154, 374);
            }
            else if (getWorld() instanceof SmallGrid)
            {
                getWorld().addObject(new Apple(), 66, 154);
            }
            else
            {
                getWorld().addObject(new Apple(), 154, 286);
            }
    
            isFirstApple = false;
        }
        else
        {
            int numCols = getWorld().getWidth() / gridSize;
            int numRows = getWorld().getHeight() / gridSize;
        
            int col = Greenfoot.getRandomNumber(numCols);
            int row = Greenfoot.getRandomNumber(numRows);
        
            int x = col * gridSize + gridSize / 2;
            int y = row * gridSize + gridSize / 2;
        
            getWorld().addObject(new Apple(), x, y);    
        }
    }
    
    private void checkApple()
    {
        SnakeParts head = parts.get(0);
        Actor apple = head.getTouchingApple();
    
        if (apple != null)
        {
            eatSound.play(); 
            ((BaseGrid)getWorld()).addScore(); 
            getWorld().removeObject(apple);
            growSnake();
            spawnApple();
        }
    }

    private void checkBombCollision()
    {
        SnakeParts head = parts.get(0);
        
        List<Bomb> bombs = getWorld().getObjectsAt(head.getX(), head.getY(), Bomb.class);
        
        if (!bombs.isEmpty())
        {
            Bomb hitBomb = bombs.get(0);
            
            ((BaseGrid)getWorld()).stopBackgroundMusic();
            bombExplodeSound.play(); 
            
            getWorld().removeObject(hitBomb);
            
            // End the game
            executeGameOver("GAME OVER");
        }
    }

    private void growSnake()
    {
        SnakeParts tail = parts.get(parts.size() - 1);
        SnakeParts newPart = new SnakeParts("middle.png");
        parts.add(parts.size()-1, newPart);
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
        ((BaseGrid)getWorld()).stopBackgroundMusic();
        isDead = true;
    
        BaseGrid world = (BaseGrid)getWorld();
    
        world.addObject(
            new EndPopup(message, world),
            world.getWidth()/2,
            world.getHeight()/2
        );
    }
    
    /**
     * Increases snake speed
     */
    public void increaseSpeed()
    {
        if (moveDelay > 2)
        {
            moveDelay--; 
        }
    }
    
    private void rotatePart(SnakeParts part, int xMove, int yMove)
    {
        if (xMove > 0)
        {
            part.setRotation(180);
        }
        else if (xMove < 0)
        {
            part.setRotation(0);
        }
        else if (yMove > 0)
        {
            part.setRotation(270);
        }
        else if (yMove < 0)
        {
            part.setRotation(90);
        }
    }
}