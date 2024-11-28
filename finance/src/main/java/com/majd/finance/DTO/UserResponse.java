package com.majd.finance.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
}
