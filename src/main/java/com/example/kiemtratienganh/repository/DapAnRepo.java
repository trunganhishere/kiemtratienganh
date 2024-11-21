package com.example.kiemtratienganh.repository;

import com.example.kiemtratienganh.entity.DapAn;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DapAnRepo extends JpaRepository<DapAn,Long> {

    @Query("select da from DapAn da where da.baiKiemTra.id =:idBKT")
    List<DapAn> getDapAnByIdBaiKiemTra(Long idBKT, Pageable pageable);
}
