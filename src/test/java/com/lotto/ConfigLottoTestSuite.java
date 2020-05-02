package com.lotto;


import com.lotto.config.ConfigLotto;
import com.lotto.pojo.LottoAttributes;
import org.junit.Assert;
import org.junit.Test;

public class ConfigLottoTestSuite {
    @Test
    public void testConfigLottoConstuctor() throws Exception {
        LottoAttributes lottoAttributes = new LottoAttributes();
        lottoAttributes.setSections(5);
        lottoAttributes.setInSection(300);
        lottoAttributes.setValueMin(10);
        lottoAttributes.setValueMax(37);

        ConfigLotto configLotto = new ConfigLotto(lottoAttributes);

        Assert.assertEquals(5, configLotto.getLottoAttributes().getSections());
        Assert.assertEquals(300, configLotto.getLottoAttributes().getInSection());
        Assert.assertEquals(10, configLotto.getLottoAttributes().getValueMin());
        Assert.assertEquals(37, configLotto.getLottoAttributes().getValueMax());

        configLotto.saveToFile();
    }
}
