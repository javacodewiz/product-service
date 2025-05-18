package com.javacodewiz.controller;

import com.javacodewiz.dto.ErrorDTO;
import com.javacodewiz.dto.ProductRequestDTO;
import com.javacodewiz.dto.ProductResponseDTO;
import com.javacodewiz.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Validated
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {

    private ProductService service;

    @Operation(summary = "save product method",description = "Save product data into DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product is created successfully",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Bad request" ,content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    })
    @PostMapping("/save")
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody @Valid ProductRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(dto));
    }

    @Operation(summary = "get product by id method",description = "Get product by ID from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product is found successfully",content = @Content(schema = @Schema(implementation = ProductResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request" ,content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Product is not found",content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    })
    @GetMapping("/products-by-id/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") Long productId){
        return  ResponseEntity.ok(service.getProductById(productId));
    }


    @Operation(summary = "get all products method",description = "Get all products from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products are found successfully",content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    })
    @GetMapping("/all-products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }



@Operation(summary = "update product method", description = "Update an existing product in the database using its ID")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product is updated successfully", content = @Content(schema = @Schema(implementation = ProductResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
        @ApiResponse(responseCode = "404", description = "Product is not found", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
})
    @PutMapping("/update-product/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") Long productId, @RequestBody @Valid ProductRequestDTO dto){
        return ResponseEntity.ok(service.updateProduct(productId, dto));
    }



    @Operation(summary = "delete product by id method", description = "Delete an existing product in the database using its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product is deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product is not found", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
    })
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        return ResponseEntity.ok(service.deleteProduct(productId));
    }


    @Operation(summary = "get product by category method", description = "Get all products by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products are found successfully", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
    })
    @GetMapping("/products-by-category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@PathVariable String category){
        return ResponseEntity.ok(service.getProductByCategory(category));
    }

@Operation(summary = "get paginated products method", description = "Get paginated products from the database using page number and page size")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products are found successfully", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductResponseDTO.class)))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
})
    @GetMapping("/products/{pageNo}/{pageSize}")
    public ResponseEntity<List<ProductResponseDTO>> getPaginatedProducts(@PathVariable  int pageNo, @PathVariable int pageSizeS){
        return ResponseEntity.ok(service.getPaginatedProducts(pageNo, pageSizeS));
    }
}
