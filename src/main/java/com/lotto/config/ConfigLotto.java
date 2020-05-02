package com.lotto.config;

import com.lotto.pojo.LottoAttributes;
import lombok.Getter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class ConfigLotto {
    private LottoAttributes lottoAttributes;

    public ConfigLotto(LottoAttributes lottoAttributes) {
        this.lottoAttributes = lottoAttributes;
    }

    public int range() {
        Random random = new Random();
        int min = lottoAttributes.getValueMin();
        int max = lottoAttributes.getValueMax();
        return random.nextInt((max - min) + 1) + min;
    }

    private int selections() {
        return lottoAttributes.getSections();
    }

    public List selectionList() {
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 1; i <= lottoAttributes.getInSection(); i++) {
            listOfNumbers.add(range());
        }
        return listOfNumbers;
    }

    private List selectionsList() {
        List<Integer> listOfSelections = new ArrayList<>();
        for (int i = 1; i <= lottoAttributes.getSections(); i ++) {
            listOfSelections.add(selections());
        }
        return listOfSelections;
    }

    private void connectSelectionsListWithSelectionList() {
        lottoAttributes.setListOfNumbers(selectionList());
        lottoAttributes.setListOfSelections(selectionsList());
    }

    public void saveToFile() throws Exception {
        connectSelectionsListWithSelectionList();
        String format = "%-20s %5d\n";
        int counter = 0;

        PrintWriter out = new PrintWriter("out.txt");
        for (Integer a : lottoAttributes.getListOfSelections()) {
            for (Integer i : lottoAttributes.getListOfNumbers()) {
                out.println(selectionList().get(i));
                counter++;
            }
            out.println("size of list: " + lottoAttributes.getListOfNumbers().size());
            out.println("\t");
        }
        out.close();
    }
}
