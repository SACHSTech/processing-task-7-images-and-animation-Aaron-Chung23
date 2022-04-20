import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
//define the images
PImage img;
PImage cocoimg;
PImage cocoMilkImg;
PImage orangutanImg;
PImage cantaloupeImg;
PImage bananaImg;
PImage cherryImg;
//Define all the Variables
float nonGravityX = 100;
float nonGravityY = 400;
float nonGravityXSpeed = 1;
float nonGravityYSpeed = 6;

float ellipseX = 100;
float ellipseY = 400;
float cocoX = 0;
float cocoY = 0;
float xSpeed = 2;
float ySpeed = 1;
float cocoxSpeed = 1;
float cocoySpeed = 2;
float yGravity = -1;
float cocoyGravity = 1;



float cocoMilkX = 100;
float cocoMilkY = 400;
float cocoMilkXSpeed = 3;
float cocoMilkYSpeed = -1;
  
float circlingRotation = 1;
float changeInRotation = 1;
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
    //Load all the images
    img = loadImage("Tree.jpeg");
    cocoimg = loadImage("Cocomeme.png");

    cocoMilkImg = loadImage("Cocomilk.png");

    orangutanImg = loadImage("Orangutan.png");
    cantaloupeImg = loadImage("Cantaloupe.png");
    bananaImg = loadImage("Anana.png");
    cherryImg = loadImage("Cherry.png");
 
  }


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

  //Insert the images and create the shapes
	image(img, 0, 0);
  image(cocoimg, cocoX, cocoY);

  image(cocoMilkImg, cocoMilkX, cocoMilkY );

  circlingShapes(); 

  ellipse(ellipseX, ellipseY, 50, 50);
  rect(nonGravityX, nonGravityY, 50, 50);
  

  // modify gravity
  ySpeed= ySpeed+ yGravity;
  /*
  xSpeed= xSpeed+ xGravity;
  */
  //Modify State
  ellipseX = ellipseX + xSpeed;
  ellipseY = ellipseY + ySpeed;
  nonGravityX = nonGravityX + nonGravityXSpeed;
  nonGravityY = nonGravityY + nonGravityYSpeed;

  cocoySpeed = cocoySpeed + cocoyGravity;
  
  cocoX = cocoX + cocoxSpeed;
  cocoY = cocoY + cocoySpeed;

  cocoMilkX = cocoMilkX + cocoMilkXSpeed;
  cocoMilkY = cocoMilkY + cocoMilkYSpeed;   
  

  //bounce off left and right
  if(ellipseX < 0 || ellipseX > width) {
    xSpeed = xSpeed * -1;
  }
  if(ellipseY < 2 || ellipseY > height) {
    ySpeed = ySpeed * -1;
  }
    if(nonGravityX < 0 || nonGravityX > width) {
    nonGravityXSpeed = nonGravityXSpeed * -1;
  }
  if(nonGravityY < 0 || nonGravityY > width) {
    nonGravityYSpeed = nonGravityYSpeed * -1;
  }
  
  if(cocoX < 0 || cocoX > width) {
    cocoxSpeed = cocoxSpeed * -1;
  }
  if(cocoY < 0 || cocoY > width) {
    cocoySpeed = cocoySpeed * -1;
  }



   if(cocoMilkX < 0 || cocoMilkX > width) {
    cocoMilkXSpeed = cocoMilkXSpeed * -1;
  }
  if(cocoMilkY < 0 || cocoMilkY > width) {
    cocoMilkYSpeed = cocoMilkYSpeed * -1;
  }

    }
  //Circling Shapes
   public void circlingShapes(){

    pushMatrix();
    translate(cocoMilkX + (150 / 2) - 10, cocoMilkY + (150 / 2) + 5);
    rotate(radians(circlingRotation));

    stroke(150, 11, 36);
    fill(255, 99, 71);
    ellipse(75, 75, 50, 50);
    image(orangutanImg, -115, -115, 50, 50);
    image(cantaloupeImg, 55, -55, 50, 50);
    image(bananaImg, -90, 90, 50, 50);
    image(cherryImg, 120, 30, 50, 50);
    popMatrix();
    circlingRotation += changeInRotation;
    
    
  }
  
  // define other methods down here.
}