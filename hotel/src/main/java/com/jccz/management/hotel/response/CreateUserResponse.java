package com.jccz.management.hotel.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {
    private String status;
    private String Message;
    private String username;
}
