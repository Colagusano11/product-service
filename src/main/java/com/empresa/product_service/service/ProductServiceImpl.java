package com.empresa.product_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.product_service.models.Product;

@Service
public class ProductServiceImpl implements ProductService {

  List<Product> products;

  public ProductServiceImpl(){
    this.products= new ArrayList<>(List.of(

      new Product(1L,"Lorenzo Villesi","PERFUME", 15, 23.15),
      new Product(2L,"Agatha Ruiz","PERFUME",23,34.65),
       new Product(3L,"Agua de Rosas","LOCION",3,56.65),
        new Product(4L,"Antonio Banderas","LOCION",23,45.65),
         new Product(5L,"Lactovic","CABELLO",23,12.65)
));

  }
  

@Override
public List<Product> getAllProducts(){

return products;
}


@Override
public Product findProductById(Long id){

  for(Product p : products){
    
    if(p.getId().equals(id)){
      return p;
      }
  }
  throw new RuntimeException("Producto no econtrado");
  }
  



  
  }
  


  








