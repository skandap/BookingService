package com.skanda.createBooking.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserSummary {
    private Long userId;
    private String name;
    private String email;
}
