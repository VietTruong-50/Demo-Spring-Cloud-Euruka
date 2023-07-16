package com.example.productService.query.controller;

import com.example.productService.query.controller.response.ProductResponse;
import com.example.productService.query.queries.GetAllProductsQuery;
import com.example.productService.query.queries.GetProductByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping(value = "", produces = "application/json")
    public List<ProductResponse> getAllProducts(){
        GetAllProductsQuery getAllProductsQuery = new GetAllProductsQuery();
        return queryGateway.query(getAllProductsQuery, ResponseTypes.multipleInstancesOf(ProductResponse.class)).join();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ProductResponse getProduct(@PathVariable String id){
        GetProductByIdQuery getProductByIdQuery = new GetProductByIdQuery();
        getProductByIdQuery.setId(id);
        return queryGateway.query(getProductByIdQuery, ResponseTypes.instanceOf(ProductResponse.class)).join();
    }
}
