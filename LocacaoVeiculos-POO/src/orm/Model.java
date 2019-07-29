package orm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import adapters.JsonParser;

public class Model {
	protected static <T> List<T> loadInstances(Class<T> classType) {
		List<T> instances = new ArrayList<>();
		String path = System.getProperty("user.dir");
		String filePath = path + "\\database\\" + classType.getSimpleName();

		try {
			File file = new File(filePath);
			instances = JsonParser.read(file, classType);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return instances;
	}
	
	protected static <T> boolean save(Class<T> classType, List<T> instances) {
		String path = System.getProperty("user.dir");
		String filePath = path + "\\database\\" + classType.getSimpleName();

		try {
			File file = new File(filePath);
			JsonParser.write(file, instances);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
}