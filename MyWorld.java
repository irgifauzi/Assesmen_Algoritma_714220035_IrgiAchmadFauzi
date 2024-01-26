import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    static int width=900,height=500;
    static int numberMusuhs=5;
    static int numberMakanans=5;
    static int nbMusuhsShot;
    static GreenfootSound carExplosionSound,eatSound,shootSound,aux,bg1;
    private GreenfootImage bgi_1,bgi_2,bgi_3;
    private long startTime;
    private long currentTimeVariation;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width,height, 1);
        for(int i=0;i<numberMusuhs;i++)
            addObject(new musuh(),20+Greenfoot.getRandomNumber(MyWorld.width-40),Greenfoot.getRandomNumber(MyWorld.height-20));
        for(int i=0;i<numberMakanans;i++)
            addObject(new Makanan(),20+Greenfoot.getRandomNumber(MyWorld.width-40),Greenfoot.getRandomNumber(MyWorld.height-20));
        addObject(new Eater(),MyWorld.width/2,MyWorld.height-20);
        nbMusuhsShot=0;
        initializeSounds();
        initializeImages();
        startTime=System.currentTimeMillis();
        
    }

    public void displayDetails(){
        this.showText("Score : "+Eater.score,50,30);
        this.showText("Lives : "+Eater.lives,550,30);
        this.showText("High Score : "+Eater.highScore,800,30);
    }

    public void initializeSounds(){
        carExplosionSound=new GreenfootSound("sounds/car_explosion.wav");
        eatSound=new GreenfootSound("sounds/eat.wav");
        shootSound=new GreenfootSound("sounds/shoot.wav");
        aux=new GreenfootSound("");
        bg1=new GreenfootSound("sounds/bg_sound.mp3");
    }
    
    public void initializeImages(){
        bgi_1=new GreenfootImage("images/gambar1.jpg");
        bgi_2=new GreenfootImage("images/bgi_4.jpg");
        bgi_3=new GreenfootImage("images/bgi_3.jpg");
    }
    
    public void regenerateMusuhs() {
      if (nbMusuhsShot >= 5) {
        for (int i = 0; i < nbMusuhsShot; i++) {
            addObject(new musuh(), 20 + Greenfoot.getRandomNumber(MyWorld.width - 40), Greenfoot.getRandomNumber(MyWorld.height - 40));
        }
        nbMusuhsShot = 0;
      }
    }
    
    public void changeBackgroundImages(){
        currentTimeVariation=System.currentTimeMillis()-startTime;
        long variationInSecs=currentTimeVariation/1000;
        if(variationInSecs%60>=0 && variationInSecs%60<=15){
            setBackground(bgi_1);
           
        }
        else if(variationInSecs%60>15 && variationInSecs%60<=30){
            setBackground(bgi_2);
           
        }
        else if(variationInSecs%60>30 && variationInSecs%60<=45){
            setBackground(bgi_3);
           
        }
        
    }

    public void playBackgroundSounds(){
        bg1.play();
    }

    public void act(){
        displayDetails();
        playBackgroundSounds();
        regenerateMusuhs();
        changeBackgroundImages();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
