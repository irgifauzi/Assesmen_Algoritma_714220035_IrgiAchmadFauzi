import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eater extends Actor
{
    /**
     * Act - do whatever the Eater wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    private GreenfootImage up = new GreenfootImage("up.png");
    private GreenfootImage down = new GreenfootImage("down.png");
    private GreenfootImage right = new GreenfootImage("right.png");
    private GreenfootImage left = new GreenfootImage("left.png");
    
    static int moveDistance=3;
    static int score;
    int limitBombs=100;
    static int eatenUlets=0;
    static int lives=2;
    static int highScore=0;
    
    
    Eater(){}
    
    public void moveEater(){
        if(Greenfoot.isKeyDown("w")){
            setImage(up);
            setLocation(getX(),getY()-moveDistance);
        }
        if(Greenfoot.isKeyDown("s")){
            setImage(down);
            setLocation(getX(),getY()+moveDistance);
        }
        if(Greenfoot.isKeyDown("d")){
            setImage(right);
            setLocation(getX()+moveDistance,getY());
        }
        if(Greenfoot.isKeyDown("a")){
            setImage(left);
            setLocation(getX()-moveDistance,getY());
        }
        if(Greenfoot.isKeyDown("Space")){
            if(limitBombs>=1){
            getWorld().addObject(new tembak(),getX(),getY());
            limitBombs-=1;
            }
        }
        if(getX()<2 || getX()>MyWorld.width-2){
            setLocation(MyWorld.width-getX(),getY());
        }
        if(getY()<2 || getY()>MyWorld.height-2){
            setLocation(getX(),MyWorld.height-getY());
        }
    }
    
    public void act()
    {
        // Add your action code here.
        eatUlet();
        moveEater();
        
        if(lives < 1){
            getWorld().stopped();
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    public void eatUlet(){
        Actor ulet=getOneObjectAtOffset(0,0,Makanan.class);
        if(ulet!=null){
            MyWorld.eatSound.play();
            getWorld().addObject(new Makanan(),Greenfoot.getRandomNumber(MyWorld.width),Greenfoot.getRandomNumber(MyWorld.height-20));
            getWorld().removeObject(ulet);
            score+=5;
            eatenUlets+=1;
        }
    }
    
}
