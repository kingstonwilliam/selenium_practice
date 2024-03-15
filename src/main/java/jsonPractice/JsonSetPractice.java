package jsonPractice;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSetPractice {
	public static void main(String[]args) throws IOException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name","Kingston");
		jsonObject.put("Age",22);

		JSONArray array = new JSONArray();
		array.add("Hello World");
		array.add("Hello Everyone");

		jsonObject.put("Special Qualities",array);

		FileWriter fileWriter = new FileWriter("kingston.json");

		fileWriter.write(jsonObject.toJSONString());
		fileWriter.close();
		}

}
