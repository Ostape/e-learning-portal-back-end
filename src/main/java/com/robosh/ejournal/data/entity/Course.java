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
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String photoPreview;

    @Column(name = "description", length = 65535)
    @Type(type = "text")
    private String description;

    private Float rating;

    @OneToMany
    private List<Lesson> lessons;

    @OneToMany
    private List<Comment> comments;

    private Boolean isVisibleCourse;
}
