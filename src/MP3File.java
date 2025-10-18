/**
 * A class to represent metadata of an mp3 file
 * @author ryandielhenn
 */
public class MP3File {
	
	private String absPath;
	private String songTitle;
	private String artist;
	
	/**
	 * @param absPath
	 * @param songTitle
	 * @param artist
	 */
	public MP3File(String absPath, String songTitle, String artist) {
		super();
		this.absPath = absPath;
		this.songTitle = songTitle;
		this.artist = artist;
	}

	/**
	 * @return the absPath
	 */
	public String getAbsPath() {
		return absPath;
	}

	/**
	 * @param absPath the absPath to set
	 */
	public void setAbsPath(String absPath) {
		this.absPath = absPath;
	}

	/**
	 * @return the songTitle
	 */
	public String getSongTitle() {
		return songTitle;
	}

	/**
	 * @param songTitle the songTitle to set
	 */
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		return "Artist: " + (this.artist.isBlank() ? "unknown" : this.artist) + "| SongTitle: " + this.songTitle; 
	}

}
