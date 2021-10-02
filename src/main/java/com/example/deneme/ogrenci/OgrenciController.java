package com.example.deneme.ogrenci;
import com.example.deneme.ortak.BaseResponse;
import com.example.deneme.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/ogrenci")
@RestController
public class OgrenciController {
    private IOgrenciService ogrenciService;
    public OgrenciController(IOgrenciService ogrenciService) {
        this.ogrenciService=ogrenciService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public OgrenciDTO kaydet(@RequestBody OgrenciDTO ogrenciDTO) throws Exception {
        return ogrenciService.kaydet(ogrenciDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public OgrenciDTO guncelle(@RequestBody OgrenciDTO ogrenciDTO) throws Exception {
        return ogrenciService.guncelle(ogrenciDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return ogrenciService.sil(id);
    }

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(ogrenciService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
}
