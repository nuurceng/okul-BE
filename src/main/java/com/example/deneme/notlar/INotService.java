package com.example.deneme.notlar;

import com.example.deneme.hoca.HocaDTO;
import com.example.deneme.ogrenci.OgrenciDTO;

import java.util.List;

public interface INotService {
    NotDTO kaydet(NotDTO notDTO) throws Exception;
    NotDTO guncelle(NotDTO notDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<NotDTO> findAll();
}
