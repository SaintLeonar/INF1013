package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileJson {

	public FileJson() {}
	
	public void save(String path, String json)
	{
		
		try {
	        FileWriter writer = new FileWriter(path);
	        writer.write(json);
	        writer.close();
	  
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public BufferedReader read(String path)
	{
		try {
			 
            BufferedReader br = new BufferedReader(new FileReader(path));
            return br;
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
}
