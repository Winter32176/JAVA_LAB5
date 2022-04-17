package lv.tsi.webshop.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
    @JsonProperty
    @Id
    Long id;

    @JsonProperty
    String name;

    @JsonProperty
    String description;

    @JsonProperty
    String pictureUrl1;

    @JsonProperty
    ProductCategory productCategory;

    @JsonProperty
    Float price;

    public Product() {
    }

    public Product(Long id, String name, String description,  String pictureUrl1, ProductCategory productCategory,Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUrl1 = pictureUrl1;
        this.productCategory = productCategory;
    }
}
