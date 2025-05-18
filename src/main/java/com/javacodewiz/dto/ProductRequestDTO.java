package com.javacodewiz.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotEmpty(message = "Product name cannot be empty")
    @Size(min = 3, message = "Product name must be at least 3 characters long")
    private String productName;
    @NotEmpty(message = "Product description cannot be empty")
    private String productDescription;
    @NotEmpty(message = "Product price cannot be empty")
    private String productPrice;
    @NotEmpty(message = "Product quantity cannot be empty")
    private String productQuantity;
    @NotEmpty(message = "Brand name cannot be empty")
    private String brandName;
    @NotEmpty(message = "Category cannot be empty")
    private String category;
}
