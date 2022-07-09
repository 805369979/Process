package com.example.standardRule;

public interface StandardHandler {

    /**
     * 校长要看哪个专业的教案
     */
    boolean support(String majorCode);

    /**
     * 教案准备
     */
    Result export(Request param);

    // 每个专业的教案标准
    void whatRule();
    void howRule();
    void doRule();

}