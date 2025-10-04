import java.util.Comparator;

/**
 * A Comparator object that can be passed to Collections.sort that specifies
 * MP3Files to be sorted by Song name
 */

public class SortBySong implements Comparator<MP3File> {

	public int compare(MP3File first, MP3File second) {
		return first.getSongTitle().compareTo(second.getSongTitle());
	}

}