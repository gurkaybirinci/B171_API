package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> getPayLoad(Integer userId, String title, Boolean completed){
        Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("userId", userId);
        payLoad.put("title", title);
        payLoad.put("completed", completed);
        return payLoad;
    }
}
