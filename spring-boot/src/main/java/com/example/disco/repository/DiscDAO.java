package com.example.disco.repository;
import java.util.ArrayList;
import java.util.List;
import com.example.disco.model.Disc;
import org.springframework.stereotype.Repository;

@Repository
public class DiscDAO extends GenericDAO<Disc, Integer> {
    public DiscDAO() {
        super(Disc.class);
    }
    // Method of DiscDAO class to return a Disc by a given Title
    public Disc findByTitle(String title) throws Exception {
        return this.read().stream()
                .filter(e -> e.getTitle().equals(title))
                .findAny().get();
    }
    // Method of DiscDAO class to return a list of Discs by a given Artist
    public List<Disc> findByArtist(String artist) throws Exception {
        List<Disc> list = new ArrayList<>();
        for(Disc d : this.read())
            if(d.getArtist().getName().equals(artist))
                list.add(d);
        return list;
    }
    // Method of DiscDAO class to return a list of Discs by a given Genre
    public List<Disc> findByGenre(String genre) throws Exception {
        List<Disc> list = new ArrayList<>();
        for(Disc d : this.read())
            if(d.getArtist().getGenre().equals(genre))
                list.add(d);
        return list;
    }
}