package com.example.disco.repository;
import java.util.ArrayList;
import java.util.List;
import com.example.disco.model.Artist;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDAO extends GenericDAO<Artist, Integer> {
    public ArtistDAO() {
        super(Artist.class);
    }
    public Artist findByName(String name) throws Exception {
        return this.read().stream()
                    .filter(e -> e.getName().equals(name))
                    .findAny().get();
    }
    public List<Artist> findByGenre(String genre) throws Exception {
        List<Artist> list = new ArrayList<>();
        for(Artist a : this.read())
            if(a.getGenre().equals(genre)) list.add(a);
        return list;
    }
}