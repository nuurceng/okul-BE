package com.example.deneme.hoca;

import com.example.deneme.ortak.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HocaDTO extends BaseDTO {
    private String adi;
    private String soyadi;
    private String tckno;

}
