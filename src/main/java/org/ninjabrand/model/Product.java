package org.ninjabrand.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String desc;
    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "cId")
//    private Category category;
}