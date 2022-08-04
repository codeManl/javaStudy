package cn.liulele.structualPatterns.bridgePattern.example;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 支付抽象类
 */
@Slf4j
public abstract class AbstractPay {

    protected PayFastMode payFastMode;

    /**
     * 构造
     *
     * @param payFastMode 快捷支付方式
     */
    public AbstractPay(PayFastMode payFastMode) {
        this.payFastMode = payFastMode;
    }

    /**
     * 付款操作
     *
     * @param tradeId 交易记录id
     * @param money   交易金额
     */
    public abstract void doPay(String tradeId, BigDecimal money);

    public void pay(String tradeId, BigDecimal money) {
        log.info("支付操作开始...");
        doPay(tradeId, money);
        log.info("支付操作结束...");
    }
}
