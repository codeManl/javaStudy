package cn.liulele;

/**
 * @author liulele
 * @description
 * @date 2022/8/16 21:41:41
 */
public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return userStr.split(separatorChar);
    }
}
