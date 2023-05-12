import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> courseList;
    private ArrayAdapter<String> adapter;
    private TextView gpaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        // Initialize views
        listView = findViewById(R.id.course_list_view);
        gpaTextView = findViewById(R.id.gpa_text_view);

        // Initialize course list
        courseList = new ArrayList<>();
        courseList.add("Calculus I - MATH101 - A");
        courseList.add("Introduction to Computer Science - COMP101 - B+");
        courseList.add("English Composition - ENGL101 - A-");
        courseList.add("History of Art - ART101 - B");

        // Initialize adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList);
        listView.setAdapter(adapter);

        // Calculate total GPA and display it
        double totalGPA = calculateTotalGPA();
        gpaTextView.setText("GPA: " + String.format("%.2f", totalGPA));
    }

    private double calculateTotalGPA() {
        double totalGPA = 0.0;
        for (String course : courseList) {
            String[] courseInfo = course.split(" - ");
            String grade = courseInfo[2];
            double gradeValue = calculateGradeValue(grade);
            totalGPA += gradeValue;
        }
        return totalGPA / courseList.size();
    }

    private double calculateGradeValue(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            case "D-":
                return 0.7;
            default:
                return 0.0;
        }
    }
}
