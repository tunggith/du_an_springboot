package com.example.demo.Controller;

import com.example.demo.Entity.MauSac;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepo mauSacRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listMauSac",mauSacRepo.findAll());
        return "MauSac";
    }
    @PostMapping("add")
    public String add(MauSac mauSac){
        mauSacRepo.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        mauSacRepo.deleteById(id);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("mauSac",mauSacRepo.findById(id).get());
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("mauSac",mauSacRepo.findById(id).get());
        return "MauSacUpdate";
    }
    @PostMapping("update/{id}")
    public String update(MauSac mauSac, @PathVariable("id")Long id){
        mauSac.setId(id);
        mauSacRepo.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
