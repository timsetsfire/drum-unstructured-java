package custom;

import com.datarobot.drum.*;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomModel extends BasePredictor { 

    String customModelPath = null;
    String negativeClassLabel = null;
    String positiveClassLabel = null;
    private String id = "MyPredictors";
    private ObjectMapper objectMapper = new ObjectMapper();

    public CustomModel(String name) {
        super(name);
    }

    @Override
    public void configure(Map<String, Object> params) throws Exception {
        customModelPath = (String) params.get("__custom_model_path__");
        negativeClassLabel = (String) params.get("negativeClassLabel");
        positiveClassLabel = (String) params.get("positiveClassLabel");
    }

    @Override
    public String predict(byte[] inputBytes) throws Exception {
        return "NOT IMPLEMENTED";
    }

    @Override
    public String predict_unstructured(byte[] inputBytes) throws JsonProcessingException { 

        // currently only returned one prediction no matter what is sent
        Map<String, String> predictions = new HashMap();
        predictions.put("message", "scoring in an unstrcutrued fashion");
        String json = null;

        try {
            json = objectMapper.writeValueAsString(predictions);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;

    }


}
