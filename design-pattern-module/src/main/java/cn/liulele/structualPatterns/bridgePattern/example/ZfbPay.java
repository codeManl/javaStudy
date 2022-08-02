package cn.liulele.structualPatterns.bridgePattern.example;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class ZfbPay extends AbstractPay {


    /**
     * 构造
     *
     * @param payFastMode 快捷支付方式
     */
    public ZfbPay(PayFastMode payFastMode) {
        super(payFastMode);
    }

    @Override
    public void doPay(String tradeId, BigDecimal money) {
        log.info("支付宝快捷支付安全校验开始...");
        boolean checkResult = payFastMode.security(tradeId);
        log.info("支付宝快捷支付安全校验结束...");

        if (checkResult) {
            log.info("支付宝支付成功,交易id: {} ,支付金额: {} 元", tradeId, money);
        } else {
            log.info("支付宝快捷支付校验失败...");
        }
    }
}
