package com.ruangong.douban.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName ReturnResult
 * @Description TODO
 * @Author bong
 * @Date 2021/10/26 10:37
 **/
@Data
public class ReturnResult{
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String,Object> data=new HashMap<>();
    public static ReturnResult getState(ResultCodeEnum re){
        ReturnResult r=new ReturnResult();
        r.setSuccess(re.getSuccess());
        r.setCode(re.getCode());
        r.setMessage(re.getMessage());
        return r;
    }
}
