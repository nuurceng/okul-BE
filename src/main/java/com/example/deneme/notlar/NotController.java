package com.example.deneme.notlar;

import com.example.deneme.ders.DersDTO;
import com.example.deneme.ders.IDersService;
import com.example.deneme.ortak.BaseResponse;
import com.example.deneme.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/not")
@RestController
public class NotController {
    private INotService notService;
    public NotController(INotService notService) {
        this.notService=notService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public NotDTO kaydet(@RequestBody NotDTO notDTO) throws Exception {
        return notService.kaydet(notDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public NotDTO guncelle(@RequestBody NotDTO notDTO) throws Exception {
        return notService.guncelle(notDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return notService.sil(id);
    }

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(notService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
}