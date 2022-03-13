package com.jccz.management.hotel.response;

import com.jccz.management.hotel.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
    private String status;
    private String message;
    private User user;
}
