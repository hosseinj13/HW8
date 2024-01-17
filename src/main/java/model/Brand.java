package model;

public class Brand {
    private int brandId;
    private String brandName;

    private String website;

    private String description;

    public Brand() {
    }

    public Brand(int brandId, String brandName, String website, String description) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.website = website;
        this.description = description;
    }
}
