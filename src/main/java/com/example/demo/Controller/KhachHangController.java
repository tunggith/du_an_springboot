package com.example.demo.Controller;

import com.example.demo.Entity.KhachHang;
import com.example.demo.Entity.NhanVien;
import com.example.demo.Repo.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepo khachHangRepo;
    @GetMapping("hien-thi")
    public String hienThiNhanVien(Model model) {
        model.addAttribute("listKhachHang", khachHangRepo.findAll());
        return "KhachHang";
    }

    @PostMapping("add")
    public String add(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        khachHangRepo.deleteById(id);
        return "redirect:/khach-hang/hien-thi";

    }
    @GetMapping("detail/{id}")
    public String detail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        redirectAttributes.addFlashAttribute("ngaySinh", dateFormat.format(khachHangRepo.findById(id).get().getNgaySinh()));
        redirectAttributes.addFlashAttribute("khachHang",khachHangRepo.findById(id).get());
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("ngaySinh", dateFormat.format(khachHangRepo.findById(id).get().getNgaySinh()));
        model.addAttribute("khachHang",khachHangRepo.findById(id).get());
        return "KhachHangUpdate";
    }
    @PostMapping("update/{id}")
    public String update(KhachHang khachHang,@PathVariable("id")Long id){
        khachHang.setId(id);
        khachHangRepo.save(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, false));
    }
}
