package com.app.product.productcatalog.thirdpartyclients.product;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.ThirdPartyProductDTO;

import java.util.List;

public interface ThirdPartyProductServiceClient {
    ThirdPartyProductDTO getProductById(Long id);

    ThirdPartyProductDTO createProduct(ProductDTO productDTO);

    List<ThirdPartyProductDTO> getAllProducts();

    ThirdPartyProductDTO deleteProductById(Long id);

    ThirdPartyProductDTO updateProductById(Long id, ThirdPartyProductDTO productDTO);
}
