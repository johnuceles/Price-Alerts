package com.houseHunting.priceAlerts.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
public class PriceInfo {

    @Id
    @Type(type="uuid-char")
    @Column(name = "resource_id")
    UUID resourceId;

    @Column(name = "house_id")
    Long houseId;

    @Column(name = "amount")
    Long amount;
}
