package com.trungphap.backend.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    @Column(nullable = false, unique = true) private String email;
    private String phone_number;
    private String address;
    private String password;
    private Date created_at;
    private Date updated_at;
    private int deleted;
    
    @ManyToOne
    private Role  role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;




}
