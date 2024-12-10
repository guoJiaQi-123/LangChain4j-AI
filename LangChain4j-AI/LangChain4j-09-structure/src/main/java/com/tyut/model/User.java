package com.tyut.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @author OldGj 2024/12/10
 * @apiNote 用户
 */
@Data
@ToString
public class User {
    private String name;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthDate;
}
