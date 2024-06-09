package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietSP;
import com.example.demo.Entity.HoaDon;
import com.example.demo.Entity.HoaDonChiTiet;
import com.example.demo.Repo.ChiTietSanPhamRepo;
import com.example.demo.Repo.HoaDonCtRepo;
import com.example.demo.Repo.HoaDonRepo;
import com.example.demo.Repo.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("ban-hang")
public class IndexController {
    @Autowired
    private HoaDonRepo hdRepo;
    @Autowired
    private ChiTietSanPhamRepo ctSpRepo;
    @Autowired
    private KhachHangRepo khRepo;
    @Autowired
    private HoaDonCtRepo hdCtRepo;

    @GetMapping("hien-thi")
    public String hienThi(Model model,
                          @RequestParam("page") Optional<Integer> page,
                          @RequestParam("pageS") Optional<Integer> pageS) {
        Pageable pageable = PageRequest.of(page.orElse(0), 3);
        Page<HoaDon> hoaDonPage = (Page<HoaDon>) hdRepo.findHoaDonByTrangThai(1, pageable);

        model.addAttribute("hoaDonPage", hoaDonPage);
        model.addAttribute("currentPage", page.orElse(0));
        model.addAttribute("totalPages", hoaDonPage.getTotalPages());
        Pageable pageableS = PageRequest.of(pageS.orElse(0), 3);
        model.addAttribute("listChiTietSanPham", ctSpRepo.findAll(pageableS));
        model.addAttribute("listKh", khRepo.findAll());
        return "index";
    }

    @GetMapping("/lich-su-mua-hang")
    public String history() {
        return "History";
    }

    @GetMapping("nhan-vien")
    public String nhanVien() {
        return "nhanVien";
    }

    @GetMapping("san-pham")
    public String sanPham() {
        return "sanPham";
    }

    @PostMapping("tao-hoa-don")
    public String taoHoaDon(HoaDon hoaDon) {
        hoaDon.setNgayTao(new Date());
        System.out.println(hoaDon.getId());
        hoaDon.setTinhTrang(1);
        hdRepo.save(hoaDon);
        return "redirect:/ban-hang/hien-thi";
    }
    @GetMapping("chon-hoa-don/{idHd}")
    public String chonHoaDon(RedirectAttributes redirectAttributes,
                             @RequestParam("pageC") Optional<Integer> pageC,
                             @PathVariable("idHd") Long idHd) {
        Optional<HoaDon> optionalHoaDon = hdRepo.findById(idHd);
        redirectAttributes.addFlashAttribute("hd", optionalHoaDon.get());
        Pageable pageable = PageRequest.of(pageC.orElse(0), 3);
        Page<HoaDonChiTiet> pageHDct = (Page<HoaDonChiTiet>) hdCtRepo.findHoaDonChiTietByHoaDon(idHd, pageable);
        redirectAttributes.addFlashAttribute("listHoaDonCt", pageHDct);
        redirectAttributes.addFlashAttribute("currentPageC", pageC.orElse(0));
        redirectAttributes.addFlashAttribute("totalPagesC", pageHDct.getTotalPages());
        double tong = 0;
        for(HoaDonChiTiet x:pageHDct){
            tong+=(x.getDonGia()*x.getSoLuong());
        }
        redirectAttributes.addFlashAttribute("tong",tong);
        return "redirect:/ban-hang/hien-thi";
}

    @GetMapping("chon-san-pham/{id}")
    public String chonSanPham(HoaDonChiTiet hoaDonChiTiet,
                              @PathVariable("id") Long id,
                              @RequestParam("idHd") Long idHd) {
        Optional<ChiTietSP> chiTietSPOpt = ctSpRepo.findById(id);
        Optional<HoaDon> hoaDonOpt = hdRepo.findById(idHd);

        if (chiTietSPOpt.isPresent() && hoaDonOpt.isPresent()) {
            ChiTietSP chiTietSP = chiTietSPOpt.get();
            HoaDon hoaDon = hoaDonOpt.get();

            // Lấy tất cả các chi tiết hóa đơn hiện có cho hóa đơn hiện tại
            List<HoaDonChiTiet> existingDetails = hdCtRepo.findByHoaDon_Id(hoaDon.getId());
            HoaDonChiTiet existingDetail = null;
            for (HoaDonChiTiet detail : existingDetails) {
                if (detail.getChiTietSP().getId().equals(chiTietSP.getId())) {
                    existingDetail = detail;
                    break;
                }
            }

            if (existingDetail != null) {
                // Nếu sản phẩm đã có trong hóa đơn, cộng dồn số lượng
                existingDetail.setSoLuong(existingDetail.getSoLuong() + 1);
                hdCtRepo.save(existingDetail);
            } else {
                // Nếu sản phẩm chưa có trong hóa đơn, tạo mới HoaDonChiTiet
                hoaDonChiTiet.setChiTietSP(chiTietSP);
                hoaDonChiTiet.setDonGia(chiTietSP.getGiaBan());
                hoaDonChiTiet.setHoaDon(hoaDon);
                hoaDonChiTiet.setSoLuong(1);
                hdCtRepo.save(hoaDonChiTiet);
            }

            // Giảm số lượng tồn kho của sản phẩm
            chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() - 1);
            ctSpRepo.save(chiTietSP);

            return "redirect:/ban-hang/chon-hoa-don/" + idHd;
        }
        return "redirect:/ban-hang/chon-hoa-don/" + idHd;
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") Long id,
                         @RequestParam("idHd") Long idHd) {
        Optional<HoaDonChiTiet> hoaDonChiTietOpt = hdCtRepo.findById(id);

        if (hoaDonChiTietOpt.isPresent()) {
            HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietOpt.get();
            ChiTietSP chiTietSP = hoaDonChiTiet.getChiTietSP();

            // Cập nhật số lượng tồn kho của sản phẩm
            chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() + hoaDonChiTiet.getSoLuong());
            ctSpRepo.save(chiTietSP);

            // Xóa chi tiết hóa đơn
            hdCtRepo.deleteById(id);
        }

        return "redirect:/ban-hang/chon-hoa-don/" + idHd;
    }

    @GetMapping("thanhToan/{id}")
    public String thanhToan(HoaDon hoaDon,@PathVariable("id")Long id) {
        hoaDon.setId(id);
        hoaDon.setTinhTrang(0);
        hdRepo.save(hoaDon);
        return "redirect:/ban-hang/hien-thi";
    }
}
