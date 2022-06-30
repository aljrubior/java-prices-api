package com.inditex.pricesapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@IdClass(PriceId.class)
@Table(name = "prices")
public class Price {

    @Id
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Id
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @JsonIgnore
    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @JsonIgnore
    @Column(name = "CURR")
    private String curr;

    @Schema(example = "1", description = "The brand identifier")
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Schema(example = "35455", description = "the product identifier")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Schema(example = "35455", description = "The identifier of the applicable price rate.")
    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    @Schema(example = "2020-06-14-00.00.00", description = "The start date and time that applies the indicated rate price.")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Schema(example = "2020-12-31-23.59.59", description = "The end date and time that applies the indicated rate price.")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Schema(example = "35.50", description = "The final sale price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
