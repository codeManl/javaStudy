package cn.cn.liulele.base;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author liulele
 * @description service层的公共返回结果集 参考RuoYi项目
 * @date 2022/12/5 12:01:01
 */


public class ServiceResult<T> implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = 200;

    /** 失败 */
    public static final int FAIL = 500;

    private int code;

    private String msg;

    private T data;

    public static <T> ServiceResult<T> success()
    {
        return restResult(null, SUCCESS, null);
    }

    public static <T> ServiceResult<T> success(T data)
    {
        return restResult(data, SUCCESS, null);
    }

    public static <T> ServiceResult<T> success(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> ServiceResult<T> fail()
    {
        return restResult(null, FAIL, null);
    }

    public static <T> ServiceResult<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> ServiceResult<T> fail(T data)
    {
        return restResult(data, FAIL, null);
    }

    public static <T> ServiceResult<T> fail(T data, String msg)
    {
        return restResult(data, FAIL, msg);
    }

    public static <T> ServiceResult<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> ServiceResult<T> restResult(T data, int code, String msg)
    {
        ServiceResult<T> apiServiceResult = new ServiceResult<>();
        apiServiceResult.setCode(code);
        apiServiceResult.setData(data);
        apiServiceResult.setMsg(msg);
        return apiServiceResult;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public static <T> Boolean isError(ServiceResult<T> ret)
    {
        return !isSuccess(ret);
    }

    public static <T> Boolean isSuccess(ServiceResult<T> ret)
    {
        return ServiceResult.SUCCESS == ret.getCode();
    }
}

