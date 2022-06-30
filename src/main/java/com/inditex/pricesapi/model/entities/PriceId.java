package com.inditex.pricesapi.model.entities;

import java.io.Serializable;

public class PriceId implements Serializable {

    private Integer brandId;

    private Long productId;

    private Integer priceList;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }
}
