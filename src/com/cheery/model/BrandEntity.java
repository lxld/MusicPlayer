package com.cheery.model;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity implements Serializable {
    private Integer brandId;
    private String brandName;
    private String desc;
}
