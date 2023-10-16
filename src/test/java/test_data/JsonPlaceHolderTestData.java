package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> getPayLoad(Integer userId, String title, Boolean completed){
        Map<String, Object> payLoad = new HashMap<>();
        if (userId!=null){
            payLoad.put("userId", userId);
        }
        if (title!=null){
            payLoad.put("title", title);
        }
        if (completed!=null){
            payLoad.put("completed", completed);
        }
        return payLoad;
    }
}
