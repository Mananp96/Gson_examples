package gson_advanced;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.StudentDetail;
import util.Constants;

import java.io.FileReader;
import java.io.FileWriter;

public class GsonStudentDetails {

    // To display null value
    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    public static void main(String[] args) {
        GsonStudentDetails gsonStudentDetails = new GsonStudentDetails();

        System.out.println(gsonStudentDetails.studentDetailDeserialize());

//        StudentDetail studentDetail = gsonStudentDetails.createStudentDetailObject();
//
//        gsonStudentDetails.writeJson(studentDetail);
    }

    private StudentDetail createStudentDetailObject() {


        return null;
    }

    public StudentDetail studentDetailDeserialize() {
        try (FileReader reader = new FileReader(Constants.STUDENT_DETAILS_FILE)) {

            // Deserialize Json File to Object (Object to JSON conversion)
            return gson.fromJson(reader, StudentDetail.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeJson(StudentDetail studentDetail) {
        try (FileWriter writer = new FileWriter(Constants.OUTPUT_STUDENTS_DETAILS_FILE)) {

            // Java Object to File
            gson.toJson(studentDetail, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
