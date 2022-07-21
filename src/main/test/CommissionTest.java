import com.example.MainApplication;
import com.example.commission.MissionProcess;
import com.example.commission.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class CommissionTest {

    @Autowired
    MissionProcess template;
    @Test
    public void testAnno(){
        Context context = new Context("hh");
        template.run(context);
    }
}
