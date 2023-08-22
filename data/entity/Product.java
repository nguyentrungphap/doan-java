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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    private int discount;
    private String thumbnail;
    private String description;
    private Date created_at;
    private Date updated_at;
    private int deleted;

    @ManyToOne
    private Category categories;

    @OneToMany(mappedBy = "product")
    private List<Gallery> galleries;
    
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}



    

