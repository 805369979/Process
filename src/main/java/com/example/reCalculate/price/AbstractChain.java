package com.example.reCalculate.price;

public abstract class AbstractChain {
    String name;
    protected AbstractChain nextHandler;
    public abstract boolean process(Context context);
}