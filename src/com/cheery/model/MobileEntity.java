package com.cheery.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileEntity implements Serializable {
    private Integer mobileId;
    private String type;
    private String os;
    private String cpu;
    private int ramSize;
    private int diskSize;
    private BrandEntity brand;
}

