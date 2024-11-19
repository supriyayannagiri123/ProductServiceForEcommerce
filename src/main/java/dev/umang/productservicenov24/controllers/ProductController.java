package dev.umang.productservicenov24.controllers;

import dev.umang.productservicenov24.dtos.CreateProductRequestDto;
import dev.umang.productservicenov24.dtos.ErrorDTO;
import dev.umang.productservicenov24.exceptions.ProductNotFoundException;
import dev.umang.productservicenov24.models.Product;
import dev.umang.productservicenov24.services.FakeStoreProductService;
import dev.umang.productservicenov24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;



    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
    /*
    at the end of the day
    api = method in my controller
     */

    /*
    GET /products
     */
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /*
    GET /products/{id}
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {

        Product p = productService.getSingleProduct(id);
        ResponseEntity<Product> responseEntity;
        if(p == null){
            responseEntity = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }else{
            responseEntity = new ResponseEntity<>(p, HttpStatus.OK);
        }



        return responseEntity;
    }

    /*
    Create a product
    {
        title :
        description:
        price:
        category:
    } => payload / request body
    POST /products
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory());
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ErrorDTO errorDTO = new ErrorDTO();
//
//        errorDTO.setMessage(productNotFoundException.getMessage());
//
//        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
//
//        return responseEntity;
//    }
}
