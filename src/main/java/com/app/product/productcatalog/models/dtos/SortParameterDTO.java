package com.app.product.productcatalog.models.dtos;

import com.app.product.productcatalog.models.enums.SortType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParameterDTO {
    private String parameterName;
    private SortType sortType;
}
