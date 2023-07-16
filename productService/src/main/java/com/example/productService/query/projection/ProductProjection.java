package com.example.productService.query.projection;

import com.example.productService.command.data.Product;
import com.example.productService.command.data.ProductRepository;
import com.example.productService.query.controller.response.ProductResponse;
import com.example.productService.query.queries.GetAllProductsQuery;
import com.example.productService.query.queries.GetProductByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public List<ProductResponse> handle(GetAllProductsQuery getAllProductsQuery){
        List<Product> products = productRepository.findAll();
        List<ProductResponse> list = new ArrayList<>();

        products.forEach(p -> {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(p, productResponse);
            list.add(productResponse);
        });

        return list;
    }


    @QueryHandler
    public ProductResponse handle(GetProductByIdQuery getProductByIdQuery){
        ProductResponse productResponse = new ProductResponse();

        Optional<Product> product= productRepository.findById(getProductByIdQuery.getId());

        if(product.isEmpty()){
            throw new RuntimeException("Product not found");
        }

        BeanUtils.copyProperties(product, productResponse);

        return productResponse;
    }
}
