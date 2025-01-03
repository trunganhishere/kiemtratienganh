package com.example.kiemtratienganh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DapAn")
public class DapAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String cau_hoi;

    @Column
    private String dap_an_1;

    @Column
    private String dap_an_2;

    @Column
    private String dap_an_3;

    @Column
    private String dap_an_4;

    @Column
    private String dap_an_chinh_xac;

    @Column
    private String dap_an_da_chon;

    @JoinColumn(name="id_nguoi_dung")
    @ManyToOne
    private NguoiDung nguoiDung;

    @JsonIgnore
    @JoinColumn(name="id_bai_kiem_tra")
    @ManyToOne
    private BaiKiemTra baiKiemTra;
}
