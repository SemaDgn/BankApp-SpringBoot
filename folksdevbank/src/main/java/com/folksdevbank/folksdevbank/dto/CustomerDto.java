package com.folksdevbank.folksdevbank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    private String id;
    private String name;
    private Integer dateofBirth;
    private CityDto city;
    private String adress;

}

