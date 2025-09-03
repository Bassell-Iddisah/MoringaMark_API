package org.ninjabrand.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId")
    private Long categoryId;
    private String name;
    private String desc;

//    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
//    private Set<Product> products = new HashSet<>();
}
