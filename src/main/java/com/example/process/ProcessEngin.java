package com.example.process;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 流程引擎
 */
@Component
public class ProcessEngin {

    @Autowired
    private ProcessNodesFactory processNodesFactory;
    /**
     * 将上下文交给流程节点处理，并返回上下文
     * @param operation
     * @param context
     * @return
     */
    public Context process(String operation, Context context) {
        // 1.路由流程节点
        List<Node> nodes = processNodesFactory.get(operation);
        if (CollectionUtils.isEmpty(nodes)) {
            throw new RuntimeException("操作类型：" + operation + " 未配置流程节点");
        }
        // 2.将 Context 交给流程节点处理，可以理解为流水线
        for (Node node : nodes) {
            node.process(context);
        }
        return context;
    }

    /**
     *  流程引擎创建实例入口
     */
    public <C extends Context, R> ProcessInstance<C, R> fire(String operation) {
        return new ProcessInstance<C, R>(operation, this);
    }
}
