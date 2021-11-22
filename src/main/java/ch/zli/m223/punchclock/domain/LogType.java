package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

@Entity
public class LogType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeName;

    public Long getId(){
        return id;
    }

}
