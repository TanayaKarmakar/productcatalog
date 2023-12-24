package com.app.product.productcatalog.models.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class CategoryDTO implements Serializable {
    private String id;
    private String name;
}
