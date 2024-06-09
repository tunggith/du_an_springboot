package com.example.demo.Controller;

import com.example.demo.Entity.NSX;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.NSXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("nha-san-xuat")
public class NSXController {
    @Autowired
    private NSXRepo nsxRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listNsx",nsxRepo.findAll());
        return "NSX";
    }
    @PostMapping("add")
    public String add(NSX nsx){
        nsxRepo.save(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        nsxRepo.deleteById(id);
        return "redirect:/nha-san-xuat/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("nsx",nsxRepo.findById(id).get());
        return "redirect:/nha-san-xuat/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("nsx",nsxRepo.findById(id).get());
        return "NSXUpdate";
    }
    @PostMapping("update/{id}")
    public String update(NSX nsx, @PathVariable("id")Long id){
        nsx.setId(id);
        nsxRepo.save(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }
}
