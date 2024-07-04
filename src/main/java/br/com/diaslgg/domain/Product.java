package br.com.diaslgg.domain;

import br.com.diaslgg.annotation.KeyType;
import br.com.diaslgg.dao.Persistent;

import java.math.BigDecimal;

public class Product implements Persistent {

    @KeyType("getCode")
    private String code;

    private String name;

    private String description;

    private BigDecimal price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
