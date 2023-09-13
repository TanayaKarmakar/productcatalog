package com.app.product.productcatalog.models.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel {
    private String name;
}
