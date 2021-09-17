package com.zadd.common.model;

import com.zadd.common.result.CodeMsgConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * response entity
 *
 * @param <T> response data type
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private T data;
    private String code;
    private String msg;

    public static Result success() {
        return successData(null);
    }

    public static Result successData(Object object) {
        return new Result(object, CodeMsgConstant.successCode, CodeMsgConstant.successMsg);
    }

    public static Result error() {
        return errorData(null);
    }

    public static Result create(Object data, String code, String msg) {
        return new Result(data, code, msg);
    }

    public static Result errorData(Object object) {
        return new Result(object, CodeMsgConstant.errorCode, CodeMsgConstant.errorMsg);
    }
}
