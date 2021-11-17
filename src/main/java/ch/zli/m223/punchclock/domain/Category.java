package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @OneToMany(mappedBy = "category")
    //@JsonIgnore
    private List<Entry> entries;

    public Long getId(){
        return id;
    }

}