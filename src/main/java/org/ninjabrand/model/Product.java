package org.ninjabrand.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String desc;
    private Double price;
//    @ManyToOne()
//    private Category category;
}