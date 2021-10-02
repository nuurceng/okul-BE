package com.example.deneme.donem;

import com.example.deneme.ders.Ders;
import com.example.deneme.notlar.Notlar;
import com.example.deneme.ogrenci.Ogrenci;
import com.example.deneme.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "donemSequence")
public class Donem extends BaseEntity {
    private String adi;

    @ManyToMany
    private List<Ogrenci> ogrenci;

    @ManyToMany(mappedBy = "donem")
    private List<Ders> ders;

    @ManyToMany(mappedBy = "donem")
    private List<Notlar> not;

}
