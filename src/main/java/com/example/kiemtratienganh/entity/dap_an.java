package com.example.kiemtratienganh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "dap_an")
public class dap_an {
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
}
