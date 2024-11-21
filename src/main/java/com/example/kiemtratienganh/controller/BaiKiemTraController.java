package com.example.kiemtratienganh.controller;

import com.example.kiemtratienganh.entity.BaiKiemTra;
import com.example.kiemtratienganh.repository.BaiKiemTraRepo;
import com.example.kiemtratienganh.repository.DapAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaiKiemTraController {
    @Autowired
    BaiKiemTraRepo baiKiemTraRepo;

    @Autowired
    DapAnRepo dapAnRepo;

    @GetMapping("/bai-kiem-tra/view-add")
    public String taoBaiKiemTra(){
        return "formAddBaiKiemTra";
    }

    @PostMapping("/bai-kiem-tra/add")
    public String themBaiKiemTra(BaiKiemTra baiKiemTra){
        baiKiemTraRepo.save(baiKiemTra);
        return "redirect:/dap-an/form-add/"+baiKiemTra.getId();
    }
}
