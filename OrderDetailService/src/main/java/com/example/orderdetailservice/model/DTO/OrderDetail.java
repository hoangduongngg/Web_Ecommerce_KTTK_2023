package com.example.orderdetailservice.model.DTO;

import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import lombok.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class OrderDetail {
    private Integer id;
    private Integer quantity;
    private Integer price;
    private Product product;

    public OrderDetail (OrderDetailEntity entity){
        this.id = entity.getId();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();

        //Call API tu service Product
        this.product = getProductById(entity.getTblProductid());
    }

    private Product getProductById(Integer productId) {
        Product p = new Product();
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8081/product?id=" + productId;
        try {
            p = rest.getForObject(url,Product.class);
        }
        catch (Exception e) {
            p = new Product(productId);
            System.out.println(e);
        }

        return p;
    }
}
