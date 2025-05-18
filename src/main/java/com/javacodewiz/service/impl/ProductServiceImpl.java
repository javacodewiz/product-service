package com.javacodewiz.service.impl;

import com.javacodewiz.dto.ProductRequestDTO;
import com.javacodewiz.dto.ProductResponseDTO;
import com.javacodewiz.exception.ResourceNotFoundException;
import com.javacodewiz.model.Product;
import com.javacodewiz.repository.ProductRepository;
import com.javacodewiz.service.ProductService;
import com.javacodewiz.utils.ProductUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;



    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO dto) {
        log.info("Saving product Started");
        Product p = ProductUtils.mapToModel(dto);
        p = repository.save(p);
        log.info("Product saved with id {}", p.getProductId());
        return ProductUtils.mapToDto(p);
    }


    @Override
    public ProductResponseDTO getProductById(Long productId) {
        log.info("getting product by id method started");
        Product p = repository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product with id "+ productId + " not found"));
        log.info("Product found with id {}", p.getProductId());
        return ProductUtils.mapToDto(p);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        log.info("getting all products started");
        List<Product> list = repository.findAll();
        log.info("getting all products completed");
        return list.stream().map(ProductUtils::mapToDto).toList();
    }


    @Override
    public ProductResponseDTO updateProduct(Long productId, ProductRequestDTO dto) {
        log.info("update product by id method started");
        Product product = repository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product with id "+ productId + " not found"));
        product.setProductName(dto.getProductName());
                product.setProductDescription(dto.getProductDescription());
                product.setProductPrice(dto.getProductPrice());
                product.setProductQuantity(dto.getProductQuantity());
                product.setBrandName(dto.getBrandName());
                product.setCategory(dto.getCategory());
                product = repository.save(product);
        log.info("product updated with id {}", product.getProductId());
        return ProductUtils.mapToDto(product);
    }

    @Override
    public String deleteProduct(Long productId) {
        log.info("delete product by id method started");
        Product p = repository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product with id "+ productId + " not found"));
        log.info("Product found with id {}", p.getProductId());
        repository.delete(p);
        return "Product deleted successfully";
    }

    @Override
    public List<ProductResponseDTO> getProductByCategory(String category) {
        log.info("getting product by category method started");
        List<Product> list = repository.findAll();
        log.info("getting product by category completed");
        return list.stream()
                .filter(p->p.getCategory().equalsIgnoreCase(category))
                .map(ProductUtils::mapToDto)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getPaginatedProducts(int pageNo, int pageSizeS) {
        log.info("getting paginated products started");
        List<ProductResponseDTO> list = repository.findAll(PageRequest.of(pageNo, pageSizeS))
                                            .stream().map(ProductUtils::mapToDto)
                                            .toList();
        log.info("getting paginated products completed");
        return list;
    }
}
