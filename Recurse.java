/**
 * A class that recursivley traverses a given directory for MP3Files.
 * @author rdielhenn
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Recurse {

	/**
	 * Takes an absolute path to a directory as input and returns an arraylist of mp3 files
	 * @param directory
	 * @return classList
	 * @throws FileNotFoundException
	 */
	public static ArrayList<MP3File> findFiles(String directory) throws FileNotFoundException{

		ArrayList<MP3File> songList = new ArrayList<MP3File>();

		//create a File object to pass to the helper method instead of a string 
		File file = new File(directory);

		//if the file exists call helper method if not throw fnf
		if (file.exists()){
			findFiles(file, songList);
		}else{
			throw new FileNotFoundException("File not found");
		}
		
		return songList;
	} 

	/**
	 * Recursive helper method
	 * @param directory
	 * @param songList
	 */
	public static void findFiles(File directory, ArrayList<MP3File> songList){

		//if the File object is a file create a MP3File object and put it into songList
		if (directory.isFile()){
			if (directory.getName().endsWith(".mp3")){
				Process.buildMP3(directory, songList);
			}
		}

		//otherwise iterate through the directory and recurse
		else if (directory.isDirectory()){
			File[] files = directory.listFiles();

			//if the directory is not empty
			if (files != null){
				//iterate over files
				for (File file : files)	{
					//make recursive call
					findFiles(file, songList);
				}
			}
		}

	}

}