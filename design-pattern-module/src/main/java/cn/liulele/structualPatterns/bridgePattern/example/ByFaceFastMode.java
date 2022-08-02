package cn.liulele.structualPatterns.bridgePattern.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ByFaceFastMode implements PayFastMode{
    @Override
    public boolean security(String tradeId) {
      log.info("刷脸支付安全校验...");
        return true;
    }
}
