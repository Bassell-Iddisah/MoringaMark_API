package org.ninjabrand.dto;

import org.ninjabrand.model.Product;

import java.util.Set;

public class CategoryDTO {
    public Long Id;
    public String name;
    public String desc;
    public Set<Product> products;
}
