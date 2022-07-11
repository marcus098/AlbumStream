import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private int year;
    private Author author;
    private double price;
    private List<Song> songList;

    public Album(String title, int year, Author author, double price){
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
        this.songList = new ArrayList<>();
    }

    public void addSong(Song song){
        songList.add(song);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "titolo: " + title;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public long countSong(){
        return songList.stream().distinct().count();
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}
