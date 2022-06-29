import com.example.MainApplication;
import com.example.process.NodeTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ProcessTest {
    @Autowired
    NodeTask nodeTask;

    @Test
    public void testAnno(){
        boolean handle = nodeTask.handle();
        System.out.println(handle);
    }
}
