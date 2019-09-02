package disco.control;
import disco.entity.Artist;
import disco.service.ArtistService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "artistControl")
@RequestScoped
public class ArtistControl {
    @EJB
    private ArtistService service;
    private Artist artist = new Artist();
    private List<Artist> artists = new ArrayList<>();

    public List<Artist> listArtists() {
        artists = service.read();
        return artists;
    }
    
    public String viewArtists() {
        return "index.xhtml";
    }
}
