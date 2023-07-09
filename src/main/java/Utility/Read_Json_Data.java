package Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Read_Json_Data {
    String n;
    String j;
    String k;
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator + "Data.json";

    public String ReadJSONData(String keyword) throws IOException, ParseException {

        Reader reader = new FileReader(path);
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {

            JSONObject jo = (JSONObject) obj;
            j = (String) jo.get(keyword);
        }
        return j;
    }


}
