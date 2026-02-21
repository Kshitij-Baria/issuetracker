package com.example.issuetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "labels")
@Getter
@Setter
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private Long id;

    @Column(name = "label_text", nullable = false, unique = true)
    private String labelText;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "labels")
    private Set<Task> tasks;
}
