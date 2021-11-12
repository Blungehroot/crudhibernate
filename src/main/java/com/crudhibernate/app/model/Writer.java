package com.crudhibernate.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "writers", schema = "public")
@Data
@RequiredArgsConstructor
public class Writer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "writer_seq")
    @SequenceGenerator(name = "writer_seq", sequenceName = "writer_seq")
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "posts_writers",
            joinColumns = { @JoinColumn(name = "writer_id") },
            inverseJoinColumns = { @JoinColumn(name = "post_id") }
    )
    private List<Post> posts;
}
