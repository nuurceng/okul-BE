package com.example.deneme.ogrenci;

import com.example.deneme.ortak.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class OgrenciDTO extends BaseDTO {
    private String ad;
    private String soyad;
    private String tcno;
}
