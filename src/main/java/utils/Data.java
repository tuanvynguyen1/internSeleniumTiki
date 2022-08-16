package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Data {
    /**
     * @param JSONArray
     * @return DataProvider
     * Convert JsonArray thành một mảng object bao gồm số mẫu test, HashMap. HashMap chứa cặp dữ liệu kiểu String Bao gồm key và value của Json
     * */
    private static Object[][] convertToObject(JSONArray array) {
        List<JSONObject> testScenarioArray = new ArrayList<JSONObject>();

        for (int i = 0; i < array.size(); i++) {
            testScenarioArray.add((JSONObject) array.get(i));

        }
        Object[][] dataProvider = new Object[testScenarioArray.size()][];

        for(int i=0;i<testScenarioArray.size();i++){
            HashMap<String, String> hashMap = new HashMap<>();
            for (Object key:
                 testScenarioArray.get(i).keySet()) {
                hashMap.put((String)key, (String) testScenarioArray.get(i).get(key));
            }
            System.out.println(hashMap);
            dataProvider[i] = new Object[] {hashMap};
        }
        return dataProvider;
    }

    public static Object[][] getData(String classname, FileReader JSONFile) throws IOException, ParseException {
        Object[][] data;
        System.out.println(classname);
        JSONArray arrayJSON = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            JSONObject inputData = (JSONObject) parser.parse(JSONFile);
            arrayJSON = (JSONArray) inputData.get(classname);

        } catch (Exception e) {
            e.printStackTrace();
        }
        data = convertToObject(arrayJSON);

        return data;
    }

}
