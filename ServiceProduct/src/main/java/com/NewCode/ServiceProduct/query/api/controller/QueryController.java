package com.NewCode.ServiceProduct.query.api.controller;

import com.NewCode.ServiceProduct.command.api.model.ProductRestModel;
import com.NewCode.ServiceProduct.query.api.queries.GetProductQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class QueryController {

    private QueryGateway queryGateway;

    public QueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    @GetMapping
    public List<ProductRestModel> getProduct(){
        GetProductQuery getProductQuery = new GetProductQuery();
        List<ProductRestModel> productRestModel = queryGateway.query(getProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModel;
    }


}
