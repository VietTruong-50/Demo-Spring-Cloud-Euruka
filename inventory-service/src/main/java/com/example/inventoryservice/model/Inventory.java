package com.example.inventoryservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    private String id;

    private String skuCode;

    private Integer quantity;
}
