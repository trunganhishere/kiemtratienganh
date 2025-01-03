package com.example.kiemtratienganh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BaiKiemTra")
public class BaiKiemTra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer so_cau_hoi;

    @Column
    private Integer so_ca_da_lam;

    @Column
    private String ten;

    @Column
    private Double diem_toi_da;

    @Column
    private Double diem_so;

    @Column
    private String thoi_gian_lam_bai;

    @JoinColumn(name = "id_danh_gia")
    @ManyToOne
    private DanhGia danh_gia;

    @JoinColumn(name = "id_nguoi_lam")
    @ManyToOne
    private NguoiDung nguoi_dung;

    @OneToMany(mappedBy = "baiKiemTra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DapAn> danhSachDapAn;

}
