package com.example.deneme.notlar;

import com.example.deneme.donem.Donem;
import com.example.deneme.ogrenci.Ogrenci;
import com.example.deneme.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "notSequence")
public class Notlar extends BaseEntity {
    /*private Integer not1;
    private Integer not2;*/

    private Integer dersNotu;

    @Enumerated
    private EnumNotTipi tip;


    @ManyToMany
    private List<Ogrenci>ogrenci;

    @ManyToMany
    private List<Donem> donem;
}
