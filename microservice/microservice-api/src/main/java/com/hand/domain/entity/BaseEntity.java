package com.hand.domain.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BaseEntity {

    private Date lastUpdate;
}