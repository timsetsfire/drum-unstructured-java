import custom.CustomModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ModelLoadTest {

  @Test
  public void test1() { 
    
    System.out.println("test");
    byte[] r = {1,2,3};
    CustomModel model = new CustomModel("test");
    try {
      String pred = model.predict_unstructured(r);
      System.out.println(pred);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
}
}