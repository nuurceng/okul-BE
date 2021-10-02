package com.example.deneme.hoca;

import com.example.deneme.ders.Ders;
import com.example.deneme.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name="hoca_tcno" , columnNames="tckno"))
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "hocaSequence")
public class Hoca extends BaseEntity {
    private String adi;
    private String soyadi;
    private String tckno;

    @ManyToMany
    List<Ders>ders;
}
