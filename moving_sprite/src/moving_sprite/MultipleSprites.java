package moving_sprite;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import tbs.simpleapp.SimpleApp;
import util.FileUtil;

public class MultipleSprites extends SimpleApp{
	Image car;
	int x = 0;
	int y = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultipleSprites();
	}
	
	public void main() 
	{
		Path path = Paths.get("/Users/nguyenle/Desktop/My_Work/Programming/Free_Time/Car/car.png");
		car = FileUtil.loadImage(path);
	}

	public void onFrame() 
	{
		screen.fill();
		screen.drawImage(car, x, y);
		//Add 1 to x every frame
		x += 1;
		//Add 1 to y every frame
		y += 1;
	}
	
	public void onMouseClick(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
}

