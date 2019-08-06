package com.groundzero.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "shopping_items")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"})
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private float quantity;

    private String image;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ShopItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShopItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getQuantity() {
        return quantity;
    }

    public ShopItem setQuantity(float quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ShopItem setImage(String image) {
        this.image = image;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public ShopItem setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public ShopItem setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void updateItem(ShopItem newShopItem) {
        this.name = newShopItem.name;
        this.description = newShopItem.description;
        this.image = newShopItem.image;
        this.quantity = newShopItem.quantity;
    }
}
