package com.example.demo.Controller;

import com.example.demo.Entity.CuaHang;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.CuaHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangRepo cuaHangRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listCuaHang",cuaHangRepo.findAll());
        return "CuaHang";
    }
    @PostMapping("add")
    public String add(CuaHang cuaHang){
        cuaHangRepo.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        cuaHangRepo.deleteById(id);
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("cuaHang",cuaHangRepo.findById(id).get());
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("cuaHang",cuaHangRepo.findById(id).get());
        return "CuaHangUpdate";
    }
    @PostMapping("update/{id}")
    public String update(CuaHang cuaHang, @PathVariable("id")Long id){
        cuaHang.setId(id);
        cuaHangRepo.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
}
