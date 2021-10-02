package com.example.deneme.donem;

import com.example.deneme.ders.DersDTO;
import com.example.deneme.hoca.HocaDTO;

import java.util.List;

public interface IDonemService {
    DonemDTO kaydet(DonemDTO donemDTO) throws Exception;
    DonemDTO guncelle(DonemDTO donemDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<DonemDTO> findAll();
}
