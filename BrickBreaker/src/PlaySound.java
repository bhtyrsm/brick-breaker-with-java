import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class PlaySound {
	
	String SoundPath;
	File file;
	FileInputStream fileInputStream;
	BufferedInputStream bufferedInputStream;
	Player player ;
	
public PlaySound(String path) {
	
	SoundPath=path;
		
}

public void CrashSound() throws JavaLayerException, FileNotFoundException 
{
	file = new File(SoundPath);
	
	fileInputStream = new FileInputStream(file);
    bufferedInputStream = new BufferedInputStream(fileInputStream); 
	player = new Player(bufferedInputStream);

	
	player.play(10); 
}


}











