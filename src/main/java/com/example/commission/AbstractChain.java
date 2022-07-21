package com.example.commission;

import com.example.reCalculate.util.SpringUtils;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
@Data
public abstract class AbstractChain {
    String name;
    // 执行状态
    String status = "UnComplete";
    protected List<String> fatherHandler = new ArrayList<>();
    protected List<String> sonHandler  = new ArrayList<>();

    // 任务节点执行逻辑
    public abstract Result process(Context context);

    public abstract void setFather(String... chains);

    public abstract void setSon(String... chains);

    //检查父类是否完成
    public Result checkFather(){
        boolean unComplete = this.fatherHandler.stream().anyMatch(task -> ((AbstractChain) SpringUtils.getBean(task)).getStatus().equals("UnComplete")  );
        if (unComplete){
            this.status = "UnComplete";
            return Result.of(this.name+"未执行",this.status,false);
        }
        return null;
    }
    // 运行子类
    public Result runSon(Context context){
        // 执行过程没有发生异常
        this.status = "Complete";
        Result result  = Result.of("任务成功","Complete",true);

        // 执行子节点
        if (CollectionUtils.isEmpty(this.sonHandler) ){
            return result;
        }
        for (String son:sonHandler) {
            AbstractChain mission = (AbstractChain) SpringUtils.getBean(son);
            Result process = mission.process(context);
            if (!process.isSuccess && process.getStatus().equals("Fail")){
                result = process;
                break;
            }
        }
        return result;
    }
}