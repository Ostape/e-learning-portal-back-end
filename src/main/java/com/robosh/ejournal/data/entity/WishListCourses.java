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
public class WishListCourses {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Column
    @ElementCollection(targetClass=Long.class)
    private List<Long> coursesId;
}
