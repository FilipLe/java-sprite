package moving_sprite;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import tbs.simpleapp.SimpleApp;
import util.FileUtil;

public class MultipleSprites extends SimpleApp{
	Image car;
	double[] xValues = new double[100];
	double[] yValues = new double[100];
	double[] dxValues = new double[100];
	double[] dyValues = new double[100];
	int numCars = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultipleSprites();
	}
	
	public void main() 
	{
		//load sprite
		Path path = Paths.get("/Users/nguyenle/Desktop/My_Work/Programming/Free_Time/Car/car.png");
		car = FileUtil.loadImage(path);
	}

	public void onFrame() 
	{
		screen.fill();
		
		for(int i = 0; i < numCars; i++) 
		{
			screen.drawImage(car, (int)xValues[i], (int)yValues[i]);
			yValues[i] += dyValues[i];
			//Move left when x-coord smaller than 0
			if(xValues[i]<0) 
			{
				xValues[i] += dxValues[i];
			}
			
			//Move right when x-coord greater than 0
			if(xValues[i]>0) 
			{
				xValues[i] -= dxValues[i];
			}
			
			//Make sprite bounce
			//Check y values, if it hits bottom of screen (y-coord = -168)
			if(yValues[i] < -168) 
			{
				yValues[i] = -168;
				//Change direction --> change sign of number
				dyValues[i] = -dyValues[i]*0.8;
				//x 0.8 because in real life, everytime object bounces off, rebound is lower
			}
			
			if(xValues[i] < -168) 
			{
				xValues[i] = -168;
				//Change direction --> change sign of number
				dxValues[i] = -dxValues[i]*0.8;
				//x 0.8 because in real life, everytime object bounces off, rebound is lower
			}
			
			if(xValues[i] > 168) 
			{
				xValues[i] = 168;
				//Change direction --> change sign of number
				dxValues[i] = -dxValues[i]*0.8;
				//x 0.8 because in real life, everytime object bounces off, rebound is lower
			}
			
			dxValues[i] -= 0.5;
			dyValues[i] -= 0.5;
		}
		
		
	}
	
	//Draw more sprites on mouse click position
	public void onMouseClick(int x, int y) 
	{
		xValues[numCars] = x;
		yValues[numCars] = y;
		numCars += 1;
	}
}

