package com.example.disco.controller;
import java.util.List;
import javax.validation.Valid;
import com.example.disco.model.Disc;
import com.example.disco.service.DiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discs")
public class DiscController {
    @Autowired
    private DiscService service;

    @GetMapping("/")
    public List<Disc> listOfDiscs() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Disc getDisc(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public void addDisc(@Valid @RequestBody Disc disc) {
        service.add(disc);
    }

    @PutMapping("/{id}")
    public void editDisc(@PathVariable("id") int id, @Valid @RequestBody Disc disc) {
        service.edit(id, disc);
    }

    @DeleteMapping("/{id}")
    public void removeDisc(@PathVariable("id") int id) {
        service.remove(id);
    }
}