package com.example.deneme.donem;

import com.example.deneme.ders.DersDTO;
import com.example.deneme.ders.IDersService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/donem")
@RestController
public class DonemController {
    private IDonemService donemService;
    public DonemController(IDonemService donemService) {
        this.donemService=donemService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public DonemDTO kaydet(@RequestBody DonemDTO donemDTO) throws Exception {
        return donemService.kaydet(donemDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public DonemDTO guncelle(@RequestBody DonemDTO donemDTO) throws Exception {
        return donemService.guncelle(donemDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return donemService.sil(id);
    }
}