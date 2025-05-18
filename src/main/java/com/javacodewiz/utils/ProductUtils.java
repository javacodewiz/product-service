package com.javacodewiz.utils;

import com.javacodewiz.dto.ProductRequestDTO;
import com.javacodewiz.dto.ProductResponseDTO;
import com.javacodewiz.model.Product;

public class ProductUtils {

    public static Product mapToModel(ProductRequestDTO product)
    {
        return Product.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .brandName(product.getBrandName())
                .category(product.getCategory()).build();
    }

    public static ProductResponseDTO mapToDto(Product product)
    {
        return ProductResponseDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .brandName(product.getBrandName())
                .category(product.getCategory()).build();
    }
}
