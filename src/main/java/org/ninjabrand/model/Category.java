package org.ninjabrand.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;
    private String desc;

//    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
//    private Set<Product> products = new HashSet<>();

//    public void addProduct(Product product) {
//        this.products.add(product);
//        product.setCategory(this);
//    }
}
