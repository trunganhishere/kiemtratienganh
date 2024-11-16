package com.example.kiemtratienganh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bai_kiem_tra")
public class bai_kiem_tra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer so_cau_hoi;

    @Column
    private Double diem_toi_da;

    @Column
    private Double diem_so;

    @Column
    private String thoi_gian_lam_bai;

    @JoinColumn(name = "id_danh_gia")
    @ManyToOne
    private danh_gia danh_gia;

    @JoinColumn(name = "id_cau_hoi")
    @ManyToOne
    private dap_an dap_an;

    @JoinColumn(name = "id_nguoi_lam")
    @ManyToOne
    private nguoi_dung nguoi_dung;

}
