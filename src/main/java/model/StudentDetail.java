package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentDetail {

    private String studentId;
    private String studentName;
    private boolean isStudentPassed;
    private List<Course> coursesRegistered;
}
