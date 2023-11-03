package com.hw.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SDTOrg implements Serializable {
    private String orgName;
    private Integer orgOrder;
    private Integer orgType;
    private String orgParentId;
}
