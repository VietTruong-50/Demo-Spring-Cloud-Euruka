package com.example.productService.command.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@AllArgsConstructor
public class DeletedProductCommand {

    @TargetAggregateIdentifier
    private String id;
}
