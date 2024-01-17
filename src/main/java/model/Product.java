package model;

import java.util.Date;

public class Product {

    private int productId;
    private String productName;
    private Date createDate;
    private int categoryId;
    private int brandId;

    public Product() {
    }

    public Product(int productId, String productName, Date createDate, int categoryId, int brandId) {
        this.productId = productId;
        this.productName = productName;
        this.createDate = createDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
