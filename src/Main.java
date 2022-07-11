import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
Data una collezione di Album. Ogni album ha: un titolo, l’autore, l’anno di pubblicazione, il prezzo e la lista di
canzoni. Eseguiamo le seguenti operazioni:
I. Ordinare gli album in ordine alfabetico e contare quante canzoni sono presenti in ogni album.
II. Trovare il numero totale delle canzoni eliminando i doppioni.
III. Trovare il numero totale di canzoni nell'album "The First Album" dell'anno 2001.
IV. Supponiamo che un cliente acquisti tutti gli album pubblicati prima dell’anno 1990. Quanto spenderebbe?
V. Visualizzare i primi 3 titoli di canzoni diverse che iniziano con la lettera F e fanno parte di album di anni
precedenti al 200
 */
public class Main {
    public static void main(String[] args) {
        List<Album> albumList = new ArrayList<>();
        Author a1 = new Author("autore1");
        albumList.add(new Album("Fff", 1980, a1, 10));
        albumList.add(new Album("Titolo2", 1970, a1, 11));
        Album alb1 = new Album("Aaaa", 2021, a1, 11);
        Album alb2 = new Album("The First Album", 2001, a1, 11);
        albumList.add(alb1);
        albumList.add(alb2);
        Song c1 = new Song("c1");
        Song c2 = new Song("c2");
        alb1.addSong(c1);
        alb1.addSong(c2);
        alb1.addSong(c2);
        alb2.addSong(c2);

        //I. Ordinare gli album in ordine alfabetico e contare quante canzoni sono presenti in ogni album.
        albumList = albumList
                .stream()
                .sorted(Comparator.comparing(Album::getTitle, (t1, t2) -> {
                    return t1.compareTo(t2);
                }))
                .collect(Collectors.toList());
        albumList.stream().forEach(album -> System.out.println(album + ": " + album.getSongList().stream().count()));
        System.out.println(albumList);

        //II. Trovare il numero totale delle canzoni eliminando i doppioni.
        System.out.println("Totale: " + albumList.stream()
                .mapToInt(album -> (int) album.countSong())
                .sum());

        System.out.println("Totale: " + albumList.stream()
                .map(album -> album.countSong())
                .reduce(0l, (a, b) -> a + b));

        //III. Trovare il numero totale di canzoni nell'album "The First Album" dell'anno 2001.
        System.out.println("Numero totale canzoni nell'album The First ALbum: " + albumList
                .stream()
                .filter(album -> album.getTitle().equals("The First Album") && album.getYear()==2001)
                .findFirst().get().countSong());

        //IV. Supponiamo che un cliente acquisti tutti gli album pubblicati prima dell’anno 1990. Quanto spenderebbe?
        System.out.println(albumList.stream()
                .filter(album -> album.getYear() < 1990)
                .map(album -> album.getPrice())
                .reduce(0.0, (a, b) -> a + b));

        //V. Visualizzare i primi 3 titoli di canzoni diverse che iniziano con la lettera F e fanno parte di album di anni
        //precedenti al 2000
        albumList.stream()
                .filter(album -> album.getTitle().charAt(0) == 'F' && album.getYear() < 2000)
                .limit(3)
                .forEach(System.out::println);
    }

}
