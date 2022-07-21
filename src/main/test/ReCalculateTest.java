import com.example.MainApplication;
import com.example.reCalculate.Event;
import com.example.reCalculate.ReCalculateTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ReCalculateTest {

    @Autowired
    ReCalculateTemplate template;
    @Test
    public void testAnno(){
        Event event = new Event();
        event.setScene("QUANTITY_CAL");
        event.setType("DEDUCE_QUANTITY_PROCESSOR");
        event.setDeduceType("Price_Deduce");
        template.action(event);
    }
}
