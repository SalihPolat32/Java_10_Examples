package com.bilgeadam.repository.entity;
/*
 * City ve Country Özellikleri Olsun
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {

    private String city;
    private String country;
}