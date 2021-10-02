package com.example.deneme.donem;
import com.example.deneme.notlar.NotDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "donemService")
public class DonemServiceImpl implements IDonemService {

    private IDonemRepo donemRepo;
    private ModelMapper modelMapper;

    @Autowired
    public DonemServiceImpl(IDonemRepo donemRepo, ModelMapper modelMapper) {
        this.donemRepo = donemRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public DonemDTO kaydet(DonemDTO donemDTO) throws Exception {
        try {
            if (donemRepo.findByAdi(donemDTO.getAdi()) != null) {
                throw new Exception("Bu ad ile daha önce bir donem kaydedilmiştir. Başka ad gir.");
            }
            donemRepo.save(modelMapper.map(donemDTO, Donem.class)); // Parametre ile gelen ders veri tabanına kayıt ediliyor.
            return modelMapper.map(donemRepo.findByAdi(donemDTO.getAdi()), DonemDTO.class); // Kayıt edilen dersi veri tabanından çekip DTO ya mapliyoruz.
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DonemDTO guncelle(DonemDTO donemDTO) throws Exception {
        Donem donem = modelMapper.map(donemDTO, Donem.class);
        donemRepo.save(donem);
        return donemDTO;
    }

    @Override
    public String sil(Long id) throws Exception {
        donemRepo.deleteById(id);
        if (donemRepo.getOne(id) == null) {
            return "Başarılı bir şekilde silinmiştir.";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DonemDTO> findAll() {
        return modelMapper.map(donemRepo.findAll(),new TypeToken<List<DonemDTO>>(){}.getType());
    }
}