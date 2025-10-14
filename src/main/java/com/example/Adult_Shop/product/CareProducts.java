package com.example.Adult_Shop.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class CareProducts extends Product {

    LocalDate expirationDate;
    double volume;
}
