package com.example.deneme.donem;

import com.example.deneme.ortak.IBaseEntityRepo;

public interface IDonemRepo extends IBaseEntityRepo<Donem, Long> {
    Donem findByAdi(String adi);
}
