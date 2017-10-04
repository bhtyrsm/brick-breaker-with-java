import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;



public class Animate implements Runnable{

	BrickBreakPanel bp;
	
	Animate(BrickBreakPanel b)
	{
		bp=b;
	}
	public void run() {
		
		while(true)
		{
			try {
				bp.update();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}//end of while
		
	}//end of run

}//end of Animate
