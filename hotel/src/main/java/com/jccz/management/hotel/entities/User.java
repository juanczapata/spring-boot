package com.jccz.management.hotel.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String hash;
    private String salt;
}
