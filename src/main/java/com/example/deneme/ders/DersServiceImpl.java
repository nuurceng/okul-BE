package com.example.deneme.ders;

import com.example.deneme.notlar.NotDTO;
import com.example.deneme.ogrenci.Ogrenci;
import com.example.deneme.ogrenci.OgrenciDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "dersService")
public class DersServiceImpl implements IDersService {

    private IDersRepo dersRepo;
    private ModelMapper modelMapper;

    @Autowired
    public DersServiceImpl(IDersRepo dersRepo, ModelMapper modelMapper) {
        this.dersRepo = dersRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DersDTO kaydet(DersDTO dersDTO) throws Exception {
        try {
            if (dersRepo.findByAdi(dersDTO.getAdi()) != null) {
                throw new Exception("Bu ad ile daha önce bir ders kaydedilmiştir. Başka ad gir.");
            }
            dersRepo.save(modelMapper.map(dersDTO, Ders.class)); // Parametre ile gelen ders veri tabanına kayıt ediliyor.
            return modelMapper.map(dersRepo.findByAdi(dersDTO.getAdi()), DersDTO.class); // Kayıt edilen dersi veri tabanından çekip DTO ya mapliuotuz.
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }




    @Override
    public DersDTO guncelle(DersDTO dersDTO) throws Exception {
        Ders ders = modelMapper.map(dersDTO, Ders.class);
        dersRepo.save(ders);
        return dersDTO;
    }

    @Override
    public String sil(Long id) throws Exception {
        dersRepo.deleteById(id);
        if(dersRepo.getOne(id)==null){
            return "Başarılı bir şekilde silinmiştir.";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DersDTO> findAll() {
        return modelMapper.map(dersRepo.findAll(),new TypeToken<List<DersDTO>>(){}.getType());
    }
}
