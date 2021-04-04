package cn.tellsea.frame.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Tellsea
 * @date 2021/03/29
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ResponseResult {

    private int code;

    private String msg;

    private int count;

    private Object data;

    public static ResponseResult success(String msg) {
        return new ResponseResult().setCode(200).setMsg(msg);
    }

    public static ResponseResult success(String msg, Object data) {
        return new ResponseResult().setCode(200).setMsg(msg).setData(data);
    }

    public static ResponseResult error(String msg) {
        return new ResponseResult().setCode(500).setMsg(msg);
    }

    public static ResponseResult error(String msg, Object data) {
        return new ResponseResult().setCode(500).setMsg(msg).setData(data);
    }

    public static ResponseResult table(int count, Object data) {
        return new ResponseResult().setCode(0).setMsg("查询成功").setCount(count).setData(data);
    }
}
