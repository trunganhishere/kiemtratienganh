package com.example.kiemtratienganh.controller;

import com.example.kiemtratienganh.entity.DapAn;
import com.example.kiemtratienganh.repository.BaiKiemTraRepo;
import com.example.kiemtratienganh.repository.DapAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DapAnController {

    @Autowired
    DapAnRepo dapAnRepo;

    @Autowired
    BaiKiemTraRepo baiKiemTraRepo;

    @GetMapping("/dap-an/form-add/{idBKT}")
    public String formAddDapAn(@PathVariable("idBKT") Long idBKT, Model model){
        model.addAttribute("idBKT",idBKT);
        return "formAddDapAn";
    }

    @PostMapping("/dap-an/add/{idBKT}")
    public String themDapAn(@PathVariable("idBKT") Long idBKT, DapAn dapAn){
        dapAn.setBaiKiemTra(baiKiemTraRepo.getReferenceById(idBKT));
        if (baiKiemTraRepo.getReferenceById(idBKT).getSo_cau_hoi() == null){
            baiKiemTraRepo.getReferenceById(idBKT).setSo_cau_hoi(0);
        }
        baiKiemTraRepo.getReferenceById(idBKT).setSo_cau_hoi(baiKiemTraRepo.getReferenceById(idBKT).getSo_cau_hoi()+1);
        dapAnRepo.save(dapAn);
        return "redirect:/dap-an/form-add/"+idBKT;
    }
}
