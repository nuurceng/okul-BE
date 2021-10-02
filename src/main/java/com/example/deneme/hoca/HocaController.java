package com.example.deneme.hoca;

import com.example.deneme.ders.DersDTO;
import com.example.deneme.ders.IDersService;
import com.example.deneme.ortak.BaseResponse;
import com.example.deneme.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/hoca")
@RestController
public class HocaController {
    private IHocaService hocaService;
    public HocaController(IHocaService hocaService) {
        this.hocaService=hocaService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public HocaDTO kaydet(@RequestBody HocaDTO hocaDTO) throws Exception {
        return hocaService.kaydet(hocaDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public HocaDTO guncelle(@RequestBody HocaDTO hocaDTO) throws Exception {
        return hocaService.guncelle(hocaDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return hocaService.sil(id);
    }

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(hocaService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
}