package com.example.deneme.hoca;

import com.example.deneme.donem.DonemDTO;
import com.example.deneme.notlar.NotDTO;

import java.util.List;

public interface IHocaService {
    HocaDTO kaydet(HocaDTO hocaDTO) throws Exception;
    HocaDTO guncelle(HocaDTO hocaDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<HocaDTO> findAll();
}
