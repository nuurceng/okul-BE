package com.example.deneme.ogrenci;

import com.example.deneme.ders.Ders;
import com.example.deneme.donem.Donem;
import com.example.deneme.ortak.BaseEntity;
import com.example.deneme.notlar.Notlar;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name="ogr_tcno" , columnNames="tcno"))
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "ogrSequence")
public class Ogrenci extends BaseEntity {
    private String ad;
    private String soyad;
    private String tcno;

    @ManyToMany(mappedBy = "ogrenci")
    private List<Ders> ders;

    @ManyToMany(mappedBy = "ogrenci")
    private List<Donem> donem;


    @ManyToMany(mappedBy = "ogrenci")
    private List<Notlar> not;

}