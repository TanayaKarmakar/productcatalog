package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.ProductSearchDTO;
import com.app.product.productcatalog.models.dtos.SortParameterDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.models.enums.SortType;
import com.app.product.productcatalog.models.mappers.ModelMapper;
import com.app.product.productcatalog.repositories.ProductRepository;
import com.app.product.productcatalog.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductDTO> searchProducts(ProductSearchDTO productSearchDTO) {
        List<SortParameterDTO> sortByParameters = productSearchDTO.getSortBy();

        Sort sort;

        if(sortByParameters.get(0).getSortType() == SortType.ASC) {
            sort = Sort.by(sortByParameters.get(0).getParameterName());
        } else {
            sort = Sort.by(sortByParameters.get(0).getParameterName()).descending();
        }

        for(int i = 0; i < sortByParameters.size(); i++) {
            if(sortByParameters.get(i).getSortType() == SortType.ASC) {
                sort = sort.and(Sort.by(sortByParameters.get(i).getParameterName()));
            } else {
                sort = sort.and(Sort.by(sortByParameters.get(i).getParameterName())).descending();
            }

        }
        Page<Product> productPage = productRepository.findAllByTitleContaining(productSearchDTO.getQuery(),
                PageRequest.of(productSearchDTO.getPageNumber(),
                        productSearchDTO.getPageSize(),
                        sort));
        List<Product> productList = productPage.getContent();
        List<ProductDTO> productDTOList = productList.stream()
                .map(ModelMapper::toProductDTO).toList();


        Page<ProductDTO> productDTOPage = new PageImpl<>(
                productDTOList,
                productPage.getPageable(),
                productPage.getTotalPages());
        
        return productDTOPage;
    }
}
