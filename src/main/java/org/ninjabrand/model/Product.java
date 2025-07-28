package org.ninjabrand.model;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String desc;
    private Double price;

    public Product(Long id, String name, String desc, Double price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public Product() {}

    // Getters
    public Long getId()  { return this.id; }
    public String getName() { return this.name; }
    public String getDesc() { return this.desc; }
    public Double getPrice() { return this.price; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDesc(String desc) { this.desc = desc; }
    public void setPrice(Double price) { this.price = price; }
}
