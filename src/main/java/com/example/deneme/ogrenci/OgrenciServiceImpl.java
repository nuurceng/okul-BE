package com.example.deneme.ogrenci;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "ogrenciService")
public class OgrenciServiceImpl implements IOgrenciService {

    private IOgrenciRepo ogrenciRepo;
    private ModelMapper modelMapper;

    @Autowired
    public OgrenciServiceImpl(IOgrenciRepo ogrenciRepo, ModelMapper modelMapper) {
        this.ogrenciRepo = ogrenciRepo;
        this.modelMapper = modelMapper;
    }





    @Override
    @Transactional(rollbackFor = Exception.class)
    public OgrenciDTO kaydet(OgrenciDTO ogrenciDTO) throws Exception {
        return modelMapper.map(ogrenciRepo.save(modelMapper.map(ogrenciDTO, Ogrenci.class)),OgrenciDTO.class);
    }

    /*
    @Override
    public OgrenciDTO kaydet(OgrenciDTO ogrenciDTO) throws Exception {
        return modelMapper.map(ogrenciRepo.save(modelMapper.map(ogrenciDTO, Ogrenci.class)),OgrenciDTO.class); // Kayıt edilen dersi veri tabanından çekip DTO ya mapliuotuz.
    }*/

    @Override
    public OgrenciDTO guncelle(OgrenciDTO ogrenciDTO) throws Exception {
        Ogrenci ogrenci = modelMapper.map(ogrenciDTO, Ogrenci.class);
        ogrenciRepo.save(ogrenci);
        return ogrenciDTO;
    }

    @Override
    public String sil(Long id) throws Exception {
        ogrenciRepo.deleteById(id);
        if(ogrenciRepo.getOne(id)==null){
            return "Başarılı bir şekilde silinmiştir.";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<OgrenciDTO> findAll() {
        return modelMapper.map(ogrenciRepo.findAll(),new TypeToken<List<OgrenciDTO>>(){}.getType());
    }
}