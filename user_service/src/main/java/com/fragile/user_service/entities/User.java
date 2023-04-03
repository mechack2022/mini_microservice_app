package com.fragile.user_service.entities;

import jakarta.persistence.*;
import lombok.*;
import com.fragile.user_service.entities.Rating;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name="users")
@Entity
public class User {
    @Id
    private String id;
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();




}
