package com.example.productService.command.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Double price;

}
