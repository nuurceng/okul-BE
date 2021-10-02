package com.example.deneme.ogrenci;

import com.example.deneme.notlar.NotDTO;

import java.util.List;

public interface IOgrenciService {
    OgrenciDTO kaydet(OgrenciDTO ogrenciDTO) throws Exception;
    OgrenciDTO guncelle(OgrenciDTO ogrenciDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<OgrenciDTO> findAll();
}
