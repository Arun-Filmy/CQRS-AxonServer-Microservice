package com.NewCode.ServiceProduct.command.api.data;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    private String productId;

    private String name;

    private BigDecimal price;

    private Integer quantity;
}
