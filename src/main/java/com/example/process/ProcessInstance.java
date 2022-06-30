package com.example.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 流程引擎实例
 */
@Slf4j
public class ProcessInstance<C extends Context, R> {
    /**
     * 用于生成一个流程 Context
     */
    private Supplier<C>    contextBuilder;
    /**
     * 被流程节点处理完成 context，使用这个resultBuilder转换为调用者指定的结果
     */
    private Function<C, R> resultBuilder;
    /**
     * 操作类型，对应一串流程节点引用
     */
    private String         operation;

    private ProcessEngin   processEngin;

    public static final Function NO_RESULT = (c) -> null;

    // 只允许同一个包内的类访问
    ProcessInstance(String operation, ProcessEngin processEngin) {
        this.operation = operation;
        this.processEngin = processEngin;
    }

    public ProcessInstance<C, R> contextBuilder(Supplier<C> contextBuilder) {
        this.contextBuilder = contextBuilder;
        return this;
    }

    public ProcessInstance<C, R> resultBuilder(Function<C, R> resultBuilder) {
        this.resultBuilder = resultBuilder;
        return this;
    }

    public ProcessInstance<C, R> noResultRequired() {
        this.resultBuilder = NO_RESULT;
        return this;
    }

    /**
     * 执行流程引擎，返回预期的结果类型
     * @return
     */
    public R run() {
        Assert.isTrue(contextBuilder != null,
            "[流程引擎] 请传入一个 ContextBuilder");
        Assert.isTrue(resultBuilder!=null,
            "[流程引擎] 请传入一个 ResultBuilder");
        Assert.isTrue(operation !=null,
            "[流程引擎] 请传入正确的 operation");
        C context = contextBuilder.get();
        processEngin.process(operation, context);
        return resultBuilder.apply(context);
    }
}
