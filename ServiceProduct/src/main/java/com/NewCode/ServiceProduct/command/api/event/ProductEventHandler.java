package com.NewCode.ServiceProduct.command.api.event;

import com.NewCode.ServiceProduct.command.api.data.Product;
import com.NewCode.ServiceProduct.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ProcessingGroup("product")
public class ProductEventHandler {

    private ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @EventHandler
    public void on(ProductCreatedEvent createdEvent) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(createdEvent,product);
        productRepository.save(product);
        throw new Exception("Exception Occure");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
