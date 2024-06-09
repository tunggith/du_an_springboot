package com.example.demo.Controller;

import com.example.demo.Entity.DongSP;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.DongSpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("dong-san-pham")
public class DongSPController {
    @Autowired
    private DongSpRepo dongSpRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listDongSp",dongSpRepo.findAll());
        return "DongSP";
    }
    @PostMapping("add")
    public String add(DongSP dongSP){
        dongSpRepo.save(dongSP);
        return "redirect:/dong-san-pham/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        dongSpRepo.deleteById(id);
        return "redirect:/dong-san-pham/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("dongSp",dongSpRepo.findById(id).get());
        return "redirect:/dong-san-pham/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("dongSp",dongSpRepo.findById(id).get());
        return "DongSPUpdate";
    }
    @PostMapping("update/{id}")
    public String update(DongSP dongSP, @PathVariable("id")Long id){
        dongSP.setId(id);
        dongSpRepo.save(dongSP);
        return "redirect:/dong-san-pham/hien-thi";
    }
}
