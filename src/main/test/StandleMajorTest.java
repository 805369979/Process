import com.example.MainApplication;
import com.example.process.NodeTask;
import com.example.standardRule.FacadeImpl;
import com.example.standardRule.Request;
import com.example.standardRule.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class StandleMajorTest {
    @Autowired
    FacadeImpl facade;

    @Test
    public void testAnno(){
        // 软件技术专业教案查看请求
        Request request = new Request();
        request.setMajor("software");
        request.setCondition(null);
        Result export = facade.export(request);
        System.out.println(export);

        // AI专业教案查看请求
        Request request1 = new Request();
        request1.setMajor("AIMajor");
        request1.setCondition(null);
        Result export1 = facade.export(request1);
        System.out.println(export1);
    }
}
