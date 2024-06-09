package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietSP;
import com.example.demo.Entity.NSX;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repo.ChiTietSanPhamRepo;
import com.example.demo.Repo.DongSpRepo;
import com.example.demo.Repo.MauSacRepo;
import com.example.demo.Repo.NSXRepo;
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
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamRepo chiTietSanPhamRepo;
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Autowired
    private NSXRepo nsxRepo;
    @Autowired
    private DongSpRepo dongSpRepo;
    @Autowired
    private MauSacRepo mauSacRepo;
    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listNSX",nsxRepo.findAll());
        model.addAttribute("listSanPham",sanPhamRepo.findAll());
        model.addAttribute("listDongSp",dongSpRepo.findAll());
        model.addAttribute("listMauSac",mauSacRepo.findAll());
        model.addAttribute("listChiTietSp",chiTietSanPhamRepo.findAll());
        return "ChiTietSp";
    }

    @PostMapping("add")
    public String add(ChiTietSP chiTietSP){
        chiTietSanPhamRepo.save(chiTietSP);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        chiTietSanPhamRepo.deleteById(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("detail/{id}")
    public String deatail(RedirectAttributes redirectAttributes, @PathVariable("id")Long id){
        redirectAttributes.addFlashAttribute("chiTietSP",chiTietSanPhamRepo.findById(id).get());
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("view-update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("listNSX",nsxRepo.findAll());
        model.addAttribute("listSanPham",sanPhamRepo.findAll());
        model.addAttribute("listDongSp",dongSpRepo.findAll());
        model.addAttribute("listMauSac",mauSacRepo.findAll());
        model.addAttribute("chiTietSP",chiTietSanPhamRepo.findById(id).get());
        return "ChiTietSPUpdate";
    }
    @PostMapping("update/{id}")
    public String update(ChiTietSP chiTietSP,@PathVariable("id")Long id){
        chiTietSP.setId(id);
        chiTietSanPhamRepo.save(chiTietSP);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
}
