package model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {

    private int productId;
    private String productName;
    private LocalDate createDate;
    private Category categoryId;
    private Brand brandId;

    public Product(String productName, LocalDate createDate, Category categoryId, Brand brandId) {
        this.productName = productName;
        this.createDate = createDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public Product(int productId, String productName, Category categoryId, Brand brandId) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
