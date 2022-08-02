package cn.liulele.structualPatterns.bridgePattern.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ByFingerprintFastMode implements PayFastMode{
    @Override
    public boolean security(String tradeId) {
      log.info("指纹支付支付安全校验...");
        return true;
    }
}
