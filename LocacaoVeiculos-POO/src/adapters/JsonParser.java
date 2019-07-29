package adapters;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JsonParser {
	public static <T> List<T> read(File file, Class<T> modelClass) throws FileNotFoundException, IOException {
		Gson gson = new Gson();
		List<T> data = new ArrayList<T>();

		try (FileReader reader = new FileReader(file); JsonReader parser = new JsonReader(reader);) {
			data = Arrays.asList(gson.fromJson(parser, Array.newInstance(modelClass, 0).getClass()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return data;
	}
	
	public static <T> boolean write(File file, List<T> instances) {
		Gson gson = new Gson();
		boolean written;

		try (Writer reader = new FileWriter(file); JsonWriter writer = new JsonWriter(reader);) {
			gson.toJson(instances, ArrayList.class, writer);
			written = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			written = false;
		}

		return written;
	}
}