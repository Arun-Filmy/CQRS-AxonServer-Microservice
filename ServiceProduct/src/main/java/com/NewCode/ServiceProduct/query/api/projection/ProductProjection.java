package com.NewCode.ServiceProduct.query.api.projection;

import com.NewCode.ServiceProduct.command.api.data.Product;
import com.NewCode.ServiceProduct.command.api.data.ProductRepository;
import com.NewCode.ServiceProduct.command.api.model.ProductRestModel;
import com.NewCode.ServiceProduct.query.api.queries.GetProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery getProductQuery){
        List<Product> products = productRepository.findAll();
        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel.builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build()).collect(Collectors.toList());

        return productRestModels;
    }
}
