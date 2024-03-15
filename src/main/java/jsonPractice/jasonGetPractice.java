package jsonPractice;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//step 1: download json simple jar file or dependency
//step 2: write an object for jason
//step 3:write file writer to store the jason array


public class jasonGetPractice {
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
				FileReader fileReader= new FileReader("kingston.json");
				Object parsedObject =jsonParser.parse(fileReader);
				JSONObject jsonObject =(JSONObject) parsedObject;    
				String name =(String)jsonObject.get("Name");
				long age=(Long)jsonObject.get("Age");
				JSONArray array=(JSONArray)jsonObject.get("Special Qualities");
				Iterator iterator= array.iterator();
				System.out.println("Name is: "+ name);
				System.out.println("Age is :"+age);
				while(iterator.hasNext()){
				System.out.println("Special Qualities"+ iterator.next());
				}
	}

}
