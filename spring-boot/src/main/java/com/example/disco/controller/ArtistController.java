package com.example.disco.controller;
import java.util.List;
import javax.validation.Valid;
import com.example.disco.model.Artist;
import com.example.disco.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService service;

    @GetMapping("/")
    public List<Artist> listOfArtists() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public void addArtist(@Valid @RequestBody Artist art) {
        service.add(art);
    }

    @PutMapping("/{id}")
    public void editArtist(@PathVariable("id") int id, @Valid @RequestBody Artist art) {
        service.edit(id, art);
    }

    @DeleteMapping("/{id}")
    public void removeArtist(@PathVariable("id") int id) {
        service.remove(id);
    }
}