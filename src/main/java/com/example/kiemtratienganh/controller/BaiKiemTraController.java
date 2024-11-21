package com.example.kiemtratienganh.controller;

import com.example.kiemtratienganh.entity.BaiKiemTra;
import com.example.kiemtratienganh.entity.DapAn;
import com.example.kiemtratienganh.repository.BaiKiemTraRepo;
import com.example.kiemtratienganh.repository.DapAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/lam-bai")
    public String formLamBai(@RequestParam("idBKT") Long idBKT, Model model,@RequestParam(value = "page",defaultValue = "0") Integer page){
        model.addAttribute("BKT",baiKiemTraRepo.getReferenceById(idBKT));
        Pageable pageable = PageRequest.of(page,1);
        model.addAttribute("page",page);
        model.addAttribute("DapAn",dapAnRepo.getDapAnByIdBaiKiemTra(idBKT,pageable));
        return "formLamBai";
    }

    @GetMapping("/lam-bai-save")
    public String save(@RequestParam("idBKT") Long idBKT,@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "dachon",required = false) String dachon,@RequestParam(value = "page",defaultValue = "0") Integer page){
        DapAn da = dapAnRepo.getReferenceById(id);
        da.setId(id);
        da.setDap_an_da_chon(dachon);
        dapAnRepo.save(da);
        BaiKiemTra bkt = baiKiemTraRepo.getReferenceById(idBKT);
        Double diem = 0.0;
        if (dachon.equals(da.getDap_an_chinh_xac())){
            diem +=(bkt.getDiem_toi_da()/bkt.getSo_cau_hoi());
            bkt.setDiem_so(diem);
        }
        bkt.setDiem_so(diem);
        bkt.setId(idBKT);
        baiKiemTraRepo.save(bkt);
        if (page >= baiKiemTraRepo.getReferenceById(idBKT).getSo_cau_hoi()){
            return "redirect:/hien-thi";
        }
        else {
            return "redirect:/lam-bai?idBKT="+idBKT+"&page="+(page);
        }
    }
}
