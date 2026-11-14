import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof of concept for a MusicPlaylist component.
 *
 * @author Nandini Eleswarapu
 */
public final class MusicPlaylistProofOfConcept {

    /**
     * Songs stored in the playlist.
     */
    private Sequence<String> songs;

    /**
     * Creates an empty playlist.
     */
    public MusicPlaylistProofOfConcept() {
        this.songs = new Sequence1L<>();
    }

    /**
     * Adds a song at the given position.
     *
     * @param position
     *            position to add the song
     * @param song
     *            song to add
     */
    public void addSong(int position, String song) {
        this.songs.add(position, song);
    }

    /**
     * Removes and returns the song at the given position.
     *
     * @param position
     *            position of the song
     * @return removed song
     */
    public String removeSong(int position) {
        return this.songs.remove(position);
    }

    /**
     * Returns the song at the given position.
     *
     * @param position
     *            position of the song
     * @return song at the position
     */
    public String songAt(int position) {
        return this.songs.entry(position);
    }

    /**
     * Returns the number of songs in the playlist.
     *
     * @return number of songs
     */
    public int length() {
        return this.songs.length();
    }

    /**
     * Checks whether a song is in the playlist.
     *
     * @param song
     *            song to search for
     * @return true if the song is found
     */
    public boolean contains(String song) {
        boolean found = false;

        for (int i = 0; i < this.songs.length(); i++) {
            if (this.songs.entry(i).equals(song)) {
                found = true;
            }
        }

        return found;
    }

    /**
     * Moves a song from one position to another.
     *
     * @param from
     *            original position
     * @param to
     *            new position
     */
    public void moveSong(int from, int to) {
        String song = this.songs.remove(from);
        this.songs.add(to, song);
    }

    /**
     * Prints every song in the playlist.
     *
     * @param out
     *            output stream
     */
    public void printPlaylist(SimpleWriter out) {
        for (int i = 0; i < this.songs.length(); i++) {
            out.println((i + 1) + ". " + this.songs.entry(i));
        }
    }

    /**
     * Demonstrates the MusicPlaylist proof of concept.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        MusicPlaylistProofOfConcept playlist = new MusicPlaylistProofOfConcept();

        playlist.addSong(0, "Good Days");
        playlist.addSong(1, "Misery Business");
        playlist.addSong(2, "The Spins");

        out.println("Original Playlist:");
        playlist.printPlaylist(out);

        out.println();
        out.println("Number of songs: " + playlist.length());

        out.println();
        out.println("Contains Misery Business: "
                + playlist.contains("Misery Business"));

        out.println();
        out.println("Moving The Spins to the beginning:");
        playlist.moveSong(2, 0);
        playlist.printPlaylist(out);

        out.println();
        out.println("Removing the second song:");
        String removed = playlist.removeSong(1);
        out.println("Removed: " + removed);

        out.println();
        out.println("Final Playlist:");
        playlist.printPlaylist(out);

        out.close();
    }
}