package gson_basic;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.Student;
import util.Constants;

import java.io.*;

/**
 * It converts JSON to and from POJO using property accessor.
 */
public class GsonDataBinding {

    public static void main(String[] args) {
        GsonDataBinding gsonDataBinding = new GsonDataBinding();
        // Create Gson Object
        Gson gson = new Gson();

        try(JsonReader jsonReader = new JsonReader(new FileReader(Constants.STUDENTS_FILE))) {

            // Deserialize Json to Object (Object to JSON conversion)
            Student[] students = gson.fromJson(jsonReader, Student[].class);
            for (Student student: students) {
                System.out.println(student);
            }

            // Serialize Object to JSON string ( Object to JSON conversion)
            String studentJsonString = gson.toJson(students);
            System.out.println(studentJsonString);

            // write to Json file
            gsonDataBinding.writeJSON(students);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * write Java Object in json form to file
     * @param students Array of Student objects
     * @throws IOException exception
     */
    private void writeJSON(Student[] students) throws IOException {
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(Constants.OUTPUT_STUDENTS_FILE);
        writer.write(gson.toJson(students));
        writer.close();
    }
}

