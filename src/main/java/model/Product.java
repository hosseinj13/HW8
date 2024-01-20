package model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {

    private int productId;
    private String productName;
    private Date createDate;
    private int categoryId;
    private int brandId;


}
