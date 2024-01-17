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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
