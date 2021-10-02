package com.example.deneme.hoca;


import com.example.deneme.ogrenci.OgrenciDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "hocaService")
public class HocaServiceImpl implements IHocaService {

    private IHocaRepo hocaRepo;
    private ModelMapper modelMapper;

    @Autowired
    public HocaServiceImpl(IHocaRepo hocaRepo, ModelMapper modelMapper) {
        this.hocaRepo = hocaRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public HocaDTO kaydet(HocaDTO hocaDTO) throws Exception {

        return modelMapper.map(hocaRepo.save(modelMapper.map(hocaDTO, Hoca.class)), HocaDTO.class);
    }

    @Override
    public HocaDTO guncelle(HocaDTO hocaDTO) throws Exception {
        Hoca hoca = modelMapper.map(hocaDTO, Hoca.class);
        hocaRepo.save(hoca);
        return hocaDTO;
    }

    @Override
    public String sil(Long id) throws Exception {
        hocaRepo.deleteById(id);
        if (hocaRepo.getOne(id) == null) {
            return "Başarılı bir şekilde silinmiştir.";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<HocaDTO> findAll() {
        return modelMapper.map(hocaRepo.findAll(),new TypeToken<List<HocaDTO>>(){}.getType());
    }
}
