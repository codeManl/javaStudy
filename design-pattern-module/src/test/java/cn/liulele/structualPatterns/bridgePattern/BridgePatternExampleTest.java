package cn.liulele.structualPatterns.bridgePattern;

import cn.liulele.structualPatterns.bridgePattern.example.AbstractPay;
import cn.liulele.structualPatterns.bridgePattern.example.ByFaceFastMode;
import cn.liulele.structualPatterns.bridgePattern.example.WeiXinPay;
import org.junit.Test;

import java.math.BigDecimal;

public class BridgePatternExampleTest {


    @Test
    public void shouldUseWeixinWithFace() {
        AbstractPay abstractPay = new WeiXinPay(new ByFaceFastMode());
        abstractPay.doPay("1", new BigDecimal(200));
    }

}
