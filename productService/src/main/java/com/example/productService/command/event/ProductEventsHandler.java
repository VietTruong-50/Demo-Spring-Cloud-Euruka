package com.example.productService.command.event;

import com.example.productService.command.data.Product;
import com.example.productService.command.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    @Autowired
    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);
        productRepository.save(product);
//        throw new RuntimeException("DB exception");

    }

    @EventHandler
    public void on(ProductUpdatedEvent productUpdatedEvent){
        productRepository.findById(productUpdatedEvent.getId()).ifPresent(product -> {
            BeanUtils.copyProperties(productUpdatedEvent, product);
            productRepository.save(product);
        });
    }

    @EventHandler
    public void on(ProductDeletedEvent productDeletedEvent){
        productRepository.deleteById(productDeletedEvent.getId());
    }
}
