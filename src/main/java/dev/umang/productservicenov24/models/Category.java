package dev.umang.productservicenov24.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;
}

/*
createdAt
lastModifiedAt
 */
/*
Can one prod have multiple categories?
1 m
m 1 => m : m
mapping table
 */
