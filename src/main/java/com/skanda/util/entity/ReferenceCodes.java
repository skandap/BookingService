package com.skanda.util.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReferenceCodes {

    private String code;
    private String codeType;
    private String description;
}
