package com.crudhibernate.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "labels", schema = "public")
@Data
@RequiredArgsConstructor
public class Label implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "label_seq")
    @SequenceGenerator(name = "label_seq", sequenceName = "label_seq")
    private Integer id;

    @Column
    private String name;
}
