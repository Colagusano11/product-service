package com.empresa.product_service.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.product_service.models.Product;
import com.empresa.product_service.service.ProductServiceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
  
  

}
