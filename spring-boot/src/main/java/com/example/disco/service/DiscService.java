package com.example.disco.service;
import java.util.ArrayList;
import java.util.List;
import com.example.disco.model.Disc;
import com.example.disco.repository.DiscDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscService {
    @Autowired
    private DiscDAO dao;

    public List<Disc> listAll() {
        List<Disc> list = new ArrayList<>();
        dao.read().forEach(list::add);
        return list;
    }

    public Disc findById(int id) {
        return dao.read().stream()
                .filter(e -> e.getId() == id)
                .findAny().get();
    }

    public void add(Disc disc) {
        dao.create(disc);
    }

    public void edit(int id, Disc disc) {
        dao.update(disc);
    }

    public void remove(int id) {
        dao.delete(id);
    }
}