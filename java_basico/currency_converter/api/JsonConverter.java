package currency_converter.api;

import com.google.gson.Gson;

public class JsonConverter {
	public static <T> T getObjectFromJson(String response, Class<T> object){
		Gson json_handler = new Gson();
		return json_handler.fromJson(response, object);
	}
}
