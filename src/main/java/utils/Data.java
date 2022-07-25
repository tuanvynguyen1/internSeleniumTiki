package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Data {
    //    public static Object[] getData(String classname, FileReader JSONFile) throws IOException, ParseException {
//        JSONParser parser = new JSONParser();
//        JSONObject jsonObject = null;
//        JSONObject jsonObject1 = null;
//        // Read JSON file
//        try {
//            jsonObject = (JSONObject) parser.parse(new FileReader("src/test/java/test/data.json"));
//            jsonObject1 = (JSONObject) jsonObject.get("Test-2");
//        } catch (IOException | ParseException exception) {
//            exception.printStackTrace();
//        }
//
//        // Array to store JSON data
//        Object[] data = new Object[1];
//
//        // Store JSON data as key/value pairs in a hashMap
//        HashMap<String, String> hashMap = new LinkedHashMap<>();
//        if (jsonObject != null) {
//            Set<String> jsonObjKeys = jsonObject1.keySet();
//            for (String jsonObjKey : jsonObjKeys) {
//                hashMap.put(jsonObjKey, (String) jsonObject1.get(jsonObjKey));
//                System.out.println(jsonObject1.get(jsonObjKey));
//            }
//        } else {
//            System.out.println("Error retrieving JSON data");
//            throw new RuntimeException();
//        }
//
//        // Store HashMap in an array and return array
//        data[0] = hashMap;
//        System.out.println(data[0]);
//        return data;
//
//    }

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
