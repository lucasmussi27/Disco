package com.example.disco.model;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Artist")
@Table(name = "artist")
public class Artist implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "art_id")
    private int id;

    @Column(name = "art_name",
	    nullable = false,
	    insertable = true,
	    updatable = true,
	    length = 50, unique = true)
    private String name;

    @Column(name = "art_genre",
	    nullable = false,
	    insertable = true,
	    updatable = true,
	    length = 35, unique = false)
    private String genre;
}