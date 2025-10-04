import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

/**
 * A class to build an MP3File object and add it to an array list
 * @author ryandielhenn
 */
public class Process {

	public static void buildMP3(File file, ArrayList<MP3File> songList) {

		try{
			//get tag from file
			AudioFile f = AudioFileIO.read(file);
			Tag fileTag = f.getTag();

			String artist = fileTag.getFirst(FieldKey.ARTIST);
			String title = fileTag.getFirst(FieldKey.TITLE);

			//create object and add to the list
			MP3File song = new MP3File(file.getAbsolutePath(), title, artist);
			songList.add(song);
		}catch(CannotReadException | ReadOnlyFileException | TagException | 
			IOException | InvalidAudioFrameException | NullPointerException e ){
			//System.out.println(e.getStackTrace());
		}

	}
}
