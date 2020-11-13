package moving_sprite;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import tbs.simpleapp.SimpleApp;
import util.FileUtil;

public class Sprite extends SimpleApp{
	//Declare the variable car
	Image car;
	int x = 0;
	int y = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sprite();
	}

	public void main() 
	{
		//Imports the car sprite
		Path p = Paths.get("/Users/nguyenle/Desktop/My_Work/Programming/Free_Time/Car/car.png");
		
		/*Image car --> variable declaration
		*FileUtil.loadImage(p) --> variable initialization
		*
		*Image car = FileUtil.loadImage(p);	
		*
		*But we are not going to declare it here,because we 
		*want to make it accessible in different methods
		*/
		
		car = FileUtil.loadImage(p);
	}
	
	public void onFrame() 
	{
		//set background to black
		screen.setColour(0);
				
		//fill screen with current color
		screen.fill();
				
		//Display car sprite on screen at (x,y) of mouse
		//-->It moves to where the mouse is
		screen.drawImage(car, x, y);
		
		/*How this works
		 * When we click on mouse --> onMouseClick(x,y)
		 * the coordinates of mouse is copied to this.x and this.y
		 * which is then copied to screen.drawImage on line 48
		 */
		
		
		/*Formula for calculating gradient
															 	   
		*		     y2 - y1 															  
		* m = ---------------------
		*		 	 x2 - x1
				
		*While loop to calculate points that lie on the line and draw Car at those position
		*Maybe every 5 pixels? or 10 pixels?
		*/
	}
	
	//Method happens when Mouse hovers over
	public void onMouseMove(int x, int y) 
	{
		
	}
	
	//Method happens only when mouse is clicked
	public void onMouseClick(int x, int y) 
	{
		//this.x refers to x on line 13
		//x refers to (int x) in line 64
		this.x = x;
		
		//this.y refers to y on line 13
		//y refers to (int y) in line 64
		this.y = y;
		System.out.println("Mouse click: " + x + "," + y);
	}
}
