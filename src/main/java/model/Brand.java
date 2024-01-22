package model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Brand {
    private int brandId;

    private String brandName;

    private String website;

    private String description;

    public Brand(int brandId) {
        this.brandId = brandId;
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand(String brandName, String website, String description) {
        this.brandName = brandName;
        this.website = website;
        this.description = description;
    }
}
