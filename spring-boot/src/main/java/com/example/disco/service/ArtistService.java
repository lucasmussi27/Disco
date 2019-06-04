package com.example.disco.service;
import com.example.disco.model.Artist;
import com.example.disco.repository.ArtistDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistDAO dao;

    public List<Artist> listAll() {
        List<Artist> list = new ArrayList<>();
        dao.read().forEach(list::add);
        return list;
    }

    public Artist findById(int id) {
        return dao.read().stream()
                .filter(e -> e.getId() == id)
                .findAny().get();
    }

    public void add(Artist art) {
        dao.create(art);
    }

    public void edit(int id, Artist art) {
        dao.update(art);
    }

    public void remove(int id) {
        dao.delete(id);
    }
}