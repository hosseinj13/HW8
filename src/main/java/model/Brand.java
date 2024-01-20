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

}
