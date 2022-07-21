package com.example.commission;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 秦同学
 */
@Component("mission2")
public class Mission2 extends AbstractChain {

    @Override
    public Result process(Context context) {

        Result result = this.checkFather();
        if (result != null){
            return result;
        }

        try {
            System.out.println("推演节点2");
            System.out.println(1/0);
        } catch (Exception e) {
            this.status = "Fail";
            return Result.of(this.name + "执行失败,任务逻辑有问题" + e.getMessage(), "Fail", false);
        }
        // 执行子类逻辑
        return runSon(context);
    }




    @Override
    public void setFather(String... chains) {
        this.fatherHandler.addAll(Arrays.asList(chains));
    }

    @Override
    public void setSon(String... chains) {
        this.sonHandler.addAll(Arrays.asList(chains));
    }

}
