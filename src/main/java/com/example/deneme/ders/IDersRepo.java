package com.example.deneme.ders;


import com.example.deneme.ortak.IBaseEntityRepo;

public interface IDersRepo extends IBaseEntityRepo<Ders, Long> {
    Ders findByAdi(String adi);
}