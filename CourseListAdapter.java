import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseListAdapter extends ArrayAdapter<Course> {
    public CourseListAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course course = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_item, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.course_name_text_view);
        TextView codeTextView = convertView.findViewById(R.id.course_code_text_view);
        TextView gradeTextView = convertView.findViewById(R.id.course_grade_text_view);

        nameTextView.setText(course.getName());
        codeTextView.setText(course.getCode());
        gradeTextView.setText(String.format("%.1f", course.getGrade()));

        return convertView;
    }
}
