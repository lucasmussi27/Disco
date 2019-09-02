package disco.entity;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "artist")
@NamedQueries(
    @NamedQuery(name = "findAll", query = "select a from Artist a"))
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private int id;
    @Column(name = "art_name", unique = true, nullable = false, length = 55)
    private String name;
    @Column(name = "art_genre", nullable = false, length = 35)
    private String genre;
}
