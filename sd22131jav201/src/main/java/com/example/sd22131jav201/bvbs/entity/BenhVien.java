package com.example.sd22131jav201.bvbs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//id INT IDENTITY(1,1) PRIMARY KEY,
//        ten_benh_vien NVARCHAR(100) NOT NULL,
//        dia_chi NVARCHAR(255) NOT NULL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "benh_vien")
public class BenhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_benh_vien")
    private String tenBenhVien;

    @Column(name = "dia_chi")
    private String diaChi;
}
