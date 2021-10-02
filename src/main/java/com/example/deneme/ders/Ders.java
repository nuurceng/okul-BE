package com.example.deneme.ders;

import com.example.deneme.donem.Donem;
import com.example.deneme.hoca.Hoca;
import com.example.deneme.ogrenci.Ogrenci;
import com.example.deneme.ortak.BaseEntity;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "dersSequence")
public class Ders extends BaseEntity {
    private String adi;

    /*@OneToOne
        private Hoca hoca;*/

    @ManyToMany(mappedBy = "ders")
    private List<Hoca> hoca;

    @ManyToMany
    private List<Ogrenci> ogrenci;


    @ManyToMany
    private List<Donem> donem;


}