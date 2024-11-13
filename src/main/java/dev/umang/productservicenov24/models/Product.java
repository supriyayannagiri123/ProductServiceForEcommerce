package dev.umang.productservicenov24.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;

    //private Category category;
    private String imageUrl;
}

/*
Cardinality
P C
1 1 -> m : 1
m 1
 */
