package com.example.sd22132jav201.bvbs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//id INT IDENTITY(1,1) PRIMARY KEY,
//        ten_bac_si NVARCHAR(100) NOT NULL,
//        tuoi INT NOT NULL,
//        gioi_tinh BIT NOT NULL,
//        benh_vien_id INT NOT NULL,
//        FOREIGN KEY (benh_vien_id) REFERENCES benh_vien(id)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bac_si")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_bac_si")
    private String tenBacSi;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "benh_vien_id", referencedColumnName = "id")
    private BenhVien benhVien;
}
