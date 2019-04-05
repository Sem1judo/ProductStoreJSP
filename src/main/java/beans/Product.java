package beans;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Product {
    private int id;
    private String productName;
    private  int quantityProduct;
    private double price;
    private LocalDateTime expiredDate;
}
