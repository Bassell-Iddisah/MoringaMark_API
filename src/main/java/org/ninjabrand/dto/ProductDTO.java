package org.ninjabrand.dto;

import lombok.Builder;
import org.ninjabrand.model.Category;

@Builder
public class ProductDTO {
    public String name;
    public String desc;
    public Double price;
    public Category category;
}
