package com.robosh.ejournal.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private int durationMinutes;

    private String imageLesson;

    private String videoUrl;

    @OneToMany
    private List<Comment> comments;
}
