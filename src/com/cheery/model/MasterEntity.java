package com.cheery.model;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterEntity implements Serializable {
    private Integer masterId;
    private String userName;
    private String passWord;
    private String realName;
    private String gender;
}
