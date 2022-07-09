package com.example.standardRule;
import lombok.Data;

@Data
public class Result {
    /**
     * 是否完成
     */
    private Boolean isFinish;
    /**
     * 备注
     */
    private String message;

    // 推荐的写法
    public static Result of(boolean isFinish,String message){
        Result result = new Result();
        result.setIsFinish(isFinish);
        result.setMessage(message);
        return result;
    }
}
