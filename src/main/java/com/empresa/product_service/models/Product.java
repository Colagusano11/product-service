package com.empresa.product_service.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;

public class Product {


 private Long id;

 @NotEmpty
 private String name;
 private String category;

 @PositiveOrZero
 private int stock;

 @Positive
 private double price;


 
public Product(){

}

 public Product(Long id, String name, String category, int stock, double price){
  this.id=id;
  this.name=name;
  this.category=category;
  this.stock=stock;
  this.price=price;


 }


 public String getName() {
  return name;
}

 public void setName(String name) {
  this.name = name;
 }

 public String getCategory() {
  return category;
 }

 public void setCategory(String category) {
  this.category = category;
 }

 public int getStock() {
  return stock;
 }

 public void setStock(int stock) {
  this.stock = stock;
 }

 public double getPrice() {
  return price;
 }

 public void setPrice(double price) {
  this.price = price;
 }


 public Long getId(){
  return id;
 }

 public void setId(Long id){
  this.id=id;
 }

 

@Override
public String toString() {
  return "Product [id=" + id + ", name=" + name + ", category=" + category + ", stock=" + stock + ", price=" + price
      + "]";
}



}
