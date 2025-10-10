package org.ninjabrand.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;

    public Users() {}
}
