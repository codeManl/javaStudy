package cn.liulele.structualpatterns.proxyPattern;

/**
 * @author 刘乐乐
 * @description 卖出接口
 * @date 2022-04-07 11:06:14
 */
public interface Sale {
    /**
     * 卖出电脑
     */
    void saleComputer();
}

/**
 * 厂家卖出电脑
 */
class RealProduce implements Sale{

    @Override
    public void saleComputer() {
        System.out.println("厂家卖出电脑...");
    }
}

/**
 * 代理商卖电脑，实际上还是厂家发货
 */
class ProxyProduce implements Sale {

    private RealProduce realProduce;

    @Override
    public void saleComputer() {
        System.out.println("代理商卖电脑...");
        if (realProduce == null) {
            realProduce = new RealProduce();
        }
        realProduce.saleComputer();
    }
}

class Test {
    public static void main(String[] args) {
        // 找代理商买电脑
        ProxyProduce proxyProduce = new ProxyProduce();
        // 代理商卖出电脑
        proxyProduce.saleComputer();
    }
}
