package com.example.deneme.ders;

import com.example.deneme.donem.DonemDTO;

import java.util.List;

public interface IDersService {
    DersDTO kaydet(DersDTO dersDTO) throws Exception;
    DersDTO guncelle(DersDTO dersDTO) throws Exception;
    String sil(Long id) throws Exception;


    List<DersDTO> findAll();
}
