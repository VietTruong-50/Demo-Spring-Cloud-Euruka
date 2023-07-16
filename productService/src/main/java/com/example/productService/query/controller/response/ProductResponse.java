package com.example.productService.query.controller.response;

import lombok.Data;

@Data
public class ProductResponse {
    private String name;

    private String description;

    private Double price;
}
