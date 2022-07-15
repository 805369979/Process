import com.example.MainApplication;
import com.example.contentCompare.DataTranVerson1.Compare;
import com.example.contentCompare.DataTranVerson1.RemoteDataTran;
import com.example.contentCompare.DataTranVerson1.Person;
import com.example.contentCompare.DataTranVerson2.Compare2;
import com.example.contentCompare.DataTranVerson2.LocalContent1;
import com.example.contentCompare.DataTranVerson2.RemoteDataTran2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class DataTranTest {

    @Autowired
    @Qualifier("Compare")
    Compare compare;

    @Autowired
    @Qualifier("RemoteDataTran1")
    RemoteDataTran remoteDataTran;

    @Autowired
    @Qualifier("Compare2")
    Compare2 compare2;

    @Autowired
    @Qualifier("RemoteDataTran2")
    RemoteDataTran2 remoteDataTran2;

    @Test
    public void testAnno(){
        Person person = new Person();
        person.setName("jj");
        HashMap<String, Person> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("huhu",person);
        remoteDataTran.update(objectObjectHashMap);

        compare.equalData(remoteDataTran.getMD5());
        compare.equalData(remoteDataTran.getMD5());
    }



    @Test
    public void testAnno2() throws InterruptedException {
        Person person = new Person();
        person.setName("jj");
        HashMap<String, Person> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("huhu",person);
        remoteDataTran2.update(objectObjectHashMap);
        Thread.sleep(3000L);
        remoteDataTran2.update(objectObjectHashMap);
        Thread.sleep(3000L);
    }
}
