package cn.liulele.structualpatterns.bridgePattern;

import cn.liulele.structualpatterns.bridgePattern.example.AbstractPay;
import cn.liulele.structualpatterns.bridgePattern.example.ByFaceFastMode;
import cn.liulele.structualpatterns.bridgePattern.example.ByFingerprintFastMode;
import cn.liulele.structualpatterns.bridgePattern.example.WeiXinPay;
import org.junit.Test;

import java.math.BigDecimal;

public class BridgePatternExampleTest {

    @Test
    public void shouldUseWeixinWithFace() {
        AbstractPay abstractPay = new WeiXinPay(new ByFaceFastMode());
        abstractPay.doPay("1", new BigDecimal("200"));
    }

    @Test
    public void shouldUseWeixinWithFingerPrint() {
        AbstractPay pay = new WeiXinPay(new ByFingerprintFastMode());
        pay.doPay("2", new BigDecimal("300"));
    }

    /**
     * 通过模板方法模式来执行操作
     */
    @Test
    public void shouldUseTemplatePatternToPay() {
        AbstractPay pay = new WeiXinPay(new ByFingerprintFastMode());
        // 模板方法模式
        pay.pay("2", new BigDecimal("300"));
    }
}
