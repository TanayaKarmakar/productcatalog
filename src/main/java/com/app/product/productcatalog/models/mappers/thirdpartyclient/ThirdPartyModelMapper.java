package com.app.product.productcatalog.models.mappers.thirdpartyclient;


import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.ThirdPartyProductDTO;

import java.util.List;


public abstract class ThirdPartyModelMapper {
    public abstract ProductDTO toDTOFromThirdPartyProduct(ThirdPartyProductDTO thirdPartyProductDTO);

    public abstract List<ProductDTO> toDTOsFromThirdPartyProduct(List<ThirdPartyProductDTO> thirdPartyProductDTOS);

    public abstract ThirdPartyProductDTO toThirdPartyDTOFromProduct(ProductDTO productDTO);

}
