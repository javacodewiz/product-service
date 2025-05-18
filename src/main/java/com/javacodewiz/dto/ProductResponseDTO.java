package com.javacodewiz.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private Long productId;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productQuantity;
    private String brandName;
    private String category;
}
