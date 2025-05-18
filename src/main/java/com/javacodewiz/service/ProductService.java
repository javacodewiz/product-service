package com.javacodewiz.service;

import com.javacodewiz.dto.ProductRequestDTO;
import com.javacodewiz.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public ProductResponseDTO saveProduct(ProductRequestDTO dto);

    public ProductResponseDTO getProductById(Long productId);

    public List<ProductResponseDTO> getAllProducts();

    public ProductResponseDTO updateProduct(Long productId, ProductRequestDTO dto);

    public String deleteProduct(Long productId);

    public List<ProductResponseDTO> getProductByCategory(String category);

    public List<ProductResponseDTO> getPaginatedProducts(int pageNo, int pageSizeS);
}
