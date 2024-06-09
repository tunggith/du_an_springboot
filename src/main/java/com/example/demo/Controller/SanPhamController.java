package com.example.demo.Controller;

import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listSanPham",sanPhamRepo.findAll());
        return "sanPham";
    }
    @PostMapping("add")
    public String add(SanPham sanPham){
        sanPhamRepo.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        sanPhamRepo.deleteById(id);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes,@PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("sanPham",sanPhamRepo.findById(id).get());
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("sanPham",sanPhamRepo.findById(id).get());
        return "SanPhamUpdate";
    }
    @PostMapping("update/{id}")
    public String update(SanPham sanPham,@PathVariable("id")Long id){
        sanPham.setId(id);
        sanPhamRepo.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
