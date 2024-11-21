package com.example.kiemtratienganh.controller;

import com.example.kiemtratienganh.entity.BaiKiemTra;
import com.example.kiemtratienganh.repository.BaiKiemTraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    BaiKiemTraRepo baiKiemTraRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        Pageable pageable = PageRequest.of(page,9);
        List<BaiKiemTra> baiKiemTra = baiKiemTraRepo.getAllBKT(pageable);
        model.addAttribute("listBKT",baiKiemTra);
        model.addAttribute("p",page);
        return "hienThi";
    }


}
