package com.example.productService.command.controller;

import com.example.productService.command.commands.CreateProductCommand;
import com.example.productService.command.commands.DeletedProductCommand;
import com.example.productService.command.commands.UpdateProductCommand;
import com.example.productService.command.controller.request.ProductDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/product")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping(value = "", produces = "application/json")
    public CreateProductCommand createNewProduct(@RequestBody ProductDTO productDTO) {
        CreateProductCommand createProductCommand = new CreateProductCommand(UUID.randomUUID().toString(), productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
        commandGateway.sendAndWait(createProductCommand);
        return createProductCommand;
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public UpdateProductCommand updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(id, productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
        commandGateway.sendAndWait(updateProductCommand);
        return updateProductCommand;
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeletedProductCommand deletedProduct(@PathVariable String id){
        DeletedProductCommand command = new DeletedProductCommand(id);
        commandGateway.sendAndWait(command);
        return command;
    }
}
