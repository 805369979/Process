package com.example.commission;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 秦同学
 */
@Component("mission4")
public class Mission4 extends AbstractChain {

    public void setName(String name){
         this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public Result process(Context context) {

        // 检查父类是否执行完成
        Result result = this.checkFather();
        if (result != null){
            return result;
        }
        // 执行主逻辑操作
        try {
            System.out.println("推演节点4");
//            System.out.println(1/0);
        }catch (Exception e){
            this.status = "Fail";
            return Result.of(this.name+"执行失败,任务逻辑有问题"+e.getMessage(),"Fail",false);
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
