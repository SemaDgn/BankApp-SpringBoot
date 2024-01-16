package com.folksdevbank.folksdevbank.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountRequest extends BaseAcoountRequest {
    private String id;
}
