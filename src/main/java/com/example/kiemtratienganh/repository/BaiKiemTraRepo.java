package com.example.kiemtratienganh.repository;

import com.example.kiemtratienganh.entity.BaiKiemTra;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaiKiemTraRepo extends JpaRepository<BaiKiemTra,Long> {

    @Query("select bkt from BaiKiemTra bkt order by bkt.id desc")
    List<BaiKiemTra> getAllBKT(Pageable pageable);

}
