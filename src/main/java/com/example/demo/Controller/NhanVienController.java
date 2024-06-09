package com.example.demo.Controller;

import com.example.demo.Entity.NhanVien;
import com.example.demo.Repo.ChucVuRepo;
import com.example.demo.Repo.CuaHangRepo;
import com.example.demo.Repo.NhanVienRepo;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepo nhanVienRepo;
    @Autowired
    private CuaHangRepo cuaHangRepo;
    @Autowired
    private ChucVuRepo chucVuRepo;

    @GetMapping("hien-thi")
    public String hienThiNhanVien(Model model) {
        model.addAttribute("listNhanVien", nhanVienRepo.findAll());
        model.addAttribute("listCuaHang", cuaHangRepo.findAll());
        model.addAttribute("listChucVu", chucVuRepo.findAll());
        return "nhanVien";
    }

    @PostMapping("add")
    public String add(NhanVien nhanVien) {
        nhanVienRepo.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        nhanVienRepo.deleteById(id);
        return "redirect:/nhan-vien/hien-thi";

    }
    @GetMapping("detail/{id}")
    public String detail(RedirectAttributes redirectAttributes,@PathVariable("id")Long id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        redirectAttributes.addFlashAttribute("ngaySinh", dateFormat.format(nhanVienRepo.findById(id).get().getNgaySinh()));
        redirectAttributes.addFlashAttribute("nhanVien",nhanVienRepo.findById(id).get());
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("ngaySinh", dateFormat.format(nhanVienRepo.findById(id).get().getNgaySinh()));
        model.addAttribute("nhanVien",nhanVienRepo.findById(id).get());
        model.addAttribute("listCuaHang", cuaHangRepo.findAll());
        model.addAttribute("listChucVu", chucVuRepo.findAll());
        return "NhanVienUpdate";
    }
    @PostMapping("update/{id}")
    public String update(NhanVien nhanVien,@PathVariable("id")Long id){
        nhanVien.setId(id);
        nhanVienRepo.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, false));
    }
}
