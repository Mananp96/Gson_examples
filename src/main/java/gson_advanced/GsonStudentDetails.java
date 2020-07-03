package gson_advanced;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Course;
import model.StudentDetail;
import util.Constants;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GsonStudentDetails {

    // To display null value & for pretty print
    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    public static void main(String[] args) {
        GsonStudentDetails gsonStudentDetails = new GsonStudentDetails();

        StudentDetail[] studentDetails = gsonStudentDetails.studentDetailDeserialize();
        for (StudentDetail studentDetail: studentDetails) {
            System.out.println(studentDetail);
        }

        StudentDetail studentDetail = gsonStudentDetails.createStudentDetailObject();

        gsonStudentDetails.writeJson(studentDetail);
    }

    private StudentDetail createStudentDetailObject() {
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentId("001");
        studentDetail.setStudentName("Smith");
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Machine learning", 80));
        courseList.add(new Course("Advance Programming Practices", 95));
        studentDetail.setCoursesRegistered(courseList);

        return studentDetail;
    }

    public StudentDetail[] studentDetailDeserialize() {
        try (FileReader reader = new FileReader(Constants.STUDENT_DETAILS_FILE)) {

            // Deserialize Json File to Object (Object to JSON conversion)
            return gson.fromJson(reader, StudentDetail[].class);

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
