package com.example.deneme.notlar;
import com.example.deneme.ogrenci.OgrenciDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "notService")
public class NotServiceImpl implements INotService {

    private final INotRepo notRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public NotServiceImpl(INotRepo notRepo, ModelMapper modelMapper) {
        this.notRepo = notRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public NotDTO kaydet(NotDTO notDTO) throws Exception {
        return modelMapper.map(notRepo.save(modelMapper.map(notDTO, Notlar.class)), NotDTO.class); // Kayıt edilen dersi veri tabanından çekip DTO ya mapliyoruz.
    }

    @Override
    public NotDTO guncelle(NotDTO notDTO) throws Exception {
        Notlar not = modelMapper.map(notDTO, Notlar.class);
        notRepo.save(not);
        return notDTO;
    }

    @Override
    public String sil(Long id) throws Exception {
        notRepo.deleteById(id);
        if (notRepo.getOne(id) == null) {
            return "Başarılı bir şekilde silinmiştir.";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotDTO> findAll() {
        return modelMapper.map(notRepo.findAll(),new TypeToken<List<NotDTO>>(){}.getType());
    }
}