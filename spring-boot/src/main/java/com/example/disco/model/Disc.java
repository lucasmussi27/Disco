package com.example.disco.model;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Disc")
@Table(name = "disc")
public class Disc implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "dis_id")
    private int id;

    @Column(name = "dis_title",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 50, unique = true)
    private String title;

    // @ForeignKey(name = "dis_artist")
    @JoinColumn(name = "dis_artist",
                referencedColumnName = "art_id",
                nullable = false,
                insertable = true,
                updatable = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Artist artist;
}