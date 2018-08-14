package com.hand.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@ToString(callSuper = true)
public class City extends BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    //@KeySql(useGeneratedKeys = true)
    private Short cityId;

    private String city;

    private Short countryId = 1;

    private Date lastUpdate;

    public City(String city) {
        this.city = city;
    }
}