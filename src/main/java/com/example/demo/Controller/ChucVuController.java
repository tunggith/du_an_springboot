package com.example.demo.Controller;

import com.example.demo.Entity.ChucVu;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.ChucVuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepo chucVuRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listChucVu",chucVuRepo.findAll());
        return "ChucVu";
    }
    @PostMapping("add")
    public String add(ChucVu chucVu){
        chucVuRepo.save(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        chucVuRepo.deleteById(id);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("chucVu",chucVuRepo.findById(id).get());
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("chucVu",chucVuRepo.findById(id).get());
        return "ChucVuUpdate";
    }
    @PostMapping("update/{id}")
    public String update(ChucVu chucVu,@PathVariable("id")Long id){
        chucVu.setId(id);
        chucVuRepo.save(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}
