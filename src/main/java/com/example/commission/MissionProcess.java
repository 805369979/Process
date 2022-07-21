package com.example.commission;

import com.example.reCalculate.util.SpringUtils;
import org.springframework.stereotype.Component;

@Component
public class MissionProcess {

    public void run(Context context){
        Mission1 mission11 = (Mission1)SpringUtils.getBean("mission1");
        mission11.setName("mission1");
        mission11.setSon("mission2","mission3");

        Mission2 mission22 = (Mission2)SpringUtils.getBean("mission2");
        mission22.setName("mission2");
        mission22.setSon("mission4");
        mission22.setFather("mission1");

        Mission3 mission33 = (Mission3)SpringUtils.getBean("mission3");
        mission33.setName("mission3");
        mission33.setSon("mission4");
        mission33.setFather("mission1");

        Mission4 mission44 = (Mission4)SpringUtils.getBean("mission4");
        mission44.setName("mission4");
        mission44.setFather("mission2","mission3");


//        chain4.setSon(chain5);

//        chain5.setName("chain5");

        Result process = mission11.process(context);
        System.out.println(process);
    }
}
