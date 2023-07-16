package com.example.productService.command.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdatedEvent {

    private String id;

    private String name;

    private String description;

    private Double price;
}
