package com.example.productService.command.aggregate;

import com.example.productService.command.commands.CreateProductCommand;
import com.example.productService.command.commands.DeletedProductCommand;
import com.example.productService.command.commands.UpdateProductCommand;
import com.example.productService.command.event.ProductCreatedEvent;
import com.example.productService.command.event.ProductDeletedEvent;
import com.example.productService.command.event.ProductUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Double price;

    public ProductAggregate(){

    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateProductCommand updateProductCommand){
        ProductUpdatedEvent event = new ProductUpdatedEvent();
        BeanUtils.copyProperties(updateProductCommand, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeletedProductCommand deletedProductCommand){
        ProductDeletedEvent productDeletedEvent = new ProductDeletedEvent();
        productDeletedEvent.setId(deletedProductCommand.getId());
        AggregateLifecycle.apply(productDeletedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.id = productCreatedEvent.getId();
        this.name = productCreatedEvent.getName();
        this.description = productCreatedEvent.getDescription();
        this.price = productCreatedEvent.getPrice();
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent productUpdatedEvent){
        this.name = productUpdatedEvent.getName();
        this.description = productUpdatedEvent.getDescription();
        this.price = productUpdatedEvent.getPrice();
    }

    @EventSourcingHandler
    public void on(ProductDeletedEvent productDeletedEvent){
        this.id = productDeletedEvent.getId();
    }

}
