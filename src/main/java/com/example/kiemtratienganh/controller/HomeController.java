package com.example.kiemtratienganh.controller;

import com.example.kiemtratienganh.entity.BaiKiemTra;
import com.example.kiemtratienganh.repository.BaiKiemTraRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    BaiKiemTraRepo baiKiemTraRepo;

    @GetMapping("/hien-thi")
    @ResponseBody
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        Pageable pageable = PageRequest.of(page,9);
        List<BaiKiemTra> baiKiemTra = baiKiemTraRepo.getAllBKT(pageable);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Chuyển đối tượng sang JSON
            String jsonString = objectMapper.writeValueAsString(baiKiemTra);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
