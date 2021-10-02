package com.example.deneme.ders;

import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/ders")
@RestController
public class DersController {
    private IDersService dersService;
    public DersController(IDersService dersService) {
        this.dersService=dersService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public DersDTO kaydet(@RequestBody DersDTO dersDTO) throws Exception {
        return dersService.kaydet(dersDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public DersDTO guncelle(@RequestBody DersDTO dersDTO) throws Exception {
        return dersService.guncelle(dersDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return dersService.sil(id);
    }
}
