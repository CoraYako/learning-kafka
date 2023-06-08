package com.learning.springbootkafka.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
}
