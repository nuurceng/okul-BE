package com.example.deneme.ortak;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Getter
@Setter
@NoArgsConstructor
/*@Table(uniqueConstraints = @UniqueConstraint(name="tckn", columnNames = "tckn"))*/ /* tc numarasını unique yapar*/
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "kisiSequence")
@Entity
public  class KisiEntity extends BaseEntity{
    private String ad;
    private String soyad;
    private String tckn;
}