package com.example.commission;

import lombok.Data;

@Data
public class Result {
    String detailMessage;
    String status;
    Boolean isSuccess;

    public static Result of(String detailMessage,String status,boolean isSuccess){
        Result result = new Result();
        result.setDetailMessage(detailMessage);
        result.setStatus(status);
        result.setIsSuccess(isSuccess);
        return result;
    }
}
