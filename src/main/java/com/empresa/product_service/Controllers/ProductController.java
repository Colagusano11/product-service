package com.empresa.product_service.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.empresa.product_service.models.Product;
import com.empresa.product_service.service.ProductServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductServiceImpl productServiceImpl;

  public ProductController(ProductServiceImpl productServiceImpl){
    this.productServiceImpl=productServiceImpl;
  }


  @GetMapping
  ResponseEntity<List> getAllProducts(){
   List<Product> product = productServiceImpl.getAllProducts();

    return ResponseEntity.ok(product);


  }

  @GetMapping("/{id}")
  ResponseEntity<Product> findProductById(@PathVariable Long id){
    try{

    Product findProduct = productServiceImpl.findProductById(id);

    return ResponseEntity.ok(findProduct);
    }catch(RuntimeException e){
      return ResponseEntity.notFound().build();
    }


    
  }

  @PostMapping
  ResponseEntity<Product> createProduct(@Validated @RequestBody Product product){

    Product productN = productServiceImpl.createProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(productN);
    
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteProduct(@PathVariable Long id){

    try{
    productServiceImpl.deleteProduct(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }catch(IllegalArgumentException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

  




  }
  
  
  
  
  

}
