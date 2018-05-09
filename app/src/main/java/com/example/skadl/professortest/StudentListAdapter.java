package com.example.skadl.professortest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by skadl on 2018-05-10.
 */

public class StudentListAdapter extends BaseAdapter {

    LayoutInflater inflater = null;
    private ArrayList<StudentListItem> studentList = null;
    private int listSize = 0;

    public StudentListAdapter(ArrayList<StudentListItem> list)
    {
        studentList = list;
        listSize = list.size();
    }

    @Override
    public int getCount() {
        return listSize;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
        {
            final Context context = viewGroup.getContext();

            if (inflater == null)
            {

                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            }

            view = inflater.inflate(R.layout.student_list_item, viewGroup, false);
        }

        TextView studentName = (TextView)view.findViewById(R.id.student_name);
        TextView studentGrade = (TextView)view.findViewById(R.id.grade);

        studentName.setText(studentList.get(i).studentName);
        studentGrade.setText(studentList.get(i).studentGrade);

        studentName.setOnClickListener(studentList.get(i).onClickListener);
        studentGrade.setOnClickListener(studentList.get(i).onClickListener);

        view.setTag(""+i);

        return view;
    }
}
