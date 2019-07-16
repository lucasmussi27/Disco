package com.example.disco.controller;
import java.util.List;
import javax.validation.Valid;
import com.example.disco.model.Artist;
import com.example.disco.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService service;

    @GetMapping("/")
    public List<Artist> listofArtists() {
        return service.listAll();
    }

    @PostMapping("/")
    public String addArtist(@Valid @RequestBody Artist art) {
        service.add(art);
        return "redirect:/artists";
    }

    @PutMapping("/edit")
    public String editArtist(@RequestParam int id, @Valid @RequestBody Artist art, Model model) {
        service.edit(id, art);
        model.addAttribute("artist", art);
        model.addAttribute("artists", service.listAll());
        return "artist-view";
    }

    @DeleteMapping("/remove")
    public String removeArtist(@RequestParam int id) {
        service.remove(id);
        return "redirect:/artists";
    }
}