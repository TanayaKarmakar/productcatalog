package com.app.product.productcatalog.models.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Setter
@Getter
public class Category extends BaseModel {
    private String name;

//    @OneToMany(mappedBy = "category")
//    private List<Product> products;
}
