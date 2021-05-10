package com.robosh.ejournal.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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

    @Column(name = "description", length = 65535)
    @Type(type="text")
    private String description;

    private int durationMinutes;

    private String imageLesson;

    private String videoUrl;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Comment> comments;
}
