package com.example.process;

/**
 * 流程节点基类
 */
public abstract class Node<T extends Context> {

    /**
     * 处理上下文
     */
    public abstract void process(T context);

    /**
     * 获取节点名称
     * 节点名同样会在 nodes.json 中用到，需要保证一一对应
     */
    public abstract String getNodeName();

    @Override
    public String toString() {
        return getNodeName();
    }
}
