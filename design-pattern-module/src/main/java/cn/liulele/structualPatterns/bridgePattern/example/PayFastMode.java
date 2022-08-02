package cn.liulele.structualPatterns.bridgePattern.example;

/**
 * 快捷支付接口,如刷脸、指纹、声纹等
 */
public interface PayFastMode {

    /**
     * 风控校验
     * @param tradeId 交易记录id
     * @return 校验结果
     */
    boolean security(String tradeId);
}
