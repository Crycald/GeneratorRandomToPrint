package com.lotto.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LottoAttributes {
    private int sections;
    private int inSection;
    private int valueMin;
    private int valueMax;
    private List <Integer> listOfNumbers;
    private List <Integer> listOfSelections;
}
