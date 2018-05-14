package com.example.skadl.professortest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class StudentGrade extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private String sessionNum, profNum, studentName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_record);

        Intent getInfo = getIntent();

        sessionNum = getInfo.getStringExtra("session_num");
        profNum = getInfo.getStringExtra("professor_name");
        studentName = getInfo.getStringExtra("student_name");


        //  학생 정보 받아오기
        name = (TextView)findViewById(R.id.student_name);

        name.setText(studentName);

        ListView listView = (ListView)findViewById(R.id.grade_list);

        String gradeInfo[][] = {{"1-12", "급소공략 1", "89", "미제출", "완료"}, {"3-2", "급소공략 2", "67", "미제출", "미응시"},
                {"4-6", "스쿠스쿠 1", "99", "제출완료", "완료"}, {"5-12", "스쿠스쿠 1", "100", "미제출", "완료"},
                {"5-22", "4주 3일차", "94", "제출완료", "완료"}, {"6-7", "4주 5일차", "100", "미제출", "완료"}};

        ArrayList<GradeItem> gradeList = new ArrayList<>();

        for(int i = 0 ; i < gradeInfo.length ; i++)
        {

            GradeItem list = new GradeItem();
            list.date = gradeInfo[i][0];
            list.quizName = gradeInfo[i][1];
            list.grade = gradeInfo[i][2];
            list.note = gradeInfo[i][3];
            list.retest = gradeInfo[i][4];
            gradeList.add(list);
            list.onClickListener = this;

        }

        GradeAdapter adapter = new GradeAdapter(gradeList);
        listView.setAdapter(adapter);

        setChart();

        //  학생별 날짜 퀴즈명 점수 오답노트 재시험응시결과 받아오기
    }

    public void onClick(View view) {

    }

    public void setChart(/* 날짜, 성적*/){

        LineChart lineChart = (LineChart)findViewById(R.id.chart);

        List<Entry> word = new ArrayList<Entry>();
        List<Entry> grammar = new ArrayList<Entry>();
        List<Entry> vocabulary = new ArrayList<Entry>();

        Entry word1 = new Entry(0f, 100f);
        word.add(word1);
        Entry word2 = new Entry(1f, 85f);
        word.add(word2);
        Entry word3 = new Entry(2f, 89f);
        word.add(word3);
        Entry word4 = new Entry(3f, 97f);
        word.add(word4);

        Entry grammar1 = new Entry(0f, 60f);
        grammar.add(grammar1);
        Entry grammar2 = new Entry(1f, 63f);
        grammar.add(grammar2);
        Entry grammar3 = new Entry(2f, 70f);
        grammar.add(grammar3);
        Entry grammar4 = new Entry(3f, 65f);
        grammar.add(grammar4);

        Entry vocabulary1 = new Entry(0f, 90f);
        vocabulary.add(vocabulary1);
        Entry vocabulary2 = new Entry(1f, 87f);
        vocabulary.add(vocabulary2);
        Entry vocabulary3 = new Entry(2f, 85f);
        vocabulary.add(vocabulary3);
        Entry vocabulary4 = new Entry(3f, 90f);
        vocabulary.add(vocabulary4);

        LineDataSet setComp1 = new LineDataSet(word, "단어");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setColor(Color.RED);
        setComp1.setCircleColorHole(Color.RED);
        setComp1.setCircleColor(Color.RED);

        LineDataSet setComp2 = new LineDataSet(grammar, "문법");
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp2.setColor(Color.YELLOW);
        setComp2.setCircleColorHole(Color.YELLOW);
        setComp2.setCircleColor(Color.YELLOW);

        LineDataSet setComp3 = new LineDataSet(vocabulary, "어휘");
        setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);

        final String[] quarters = new String[] { "2월", "3월", "4월", "5월" };

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }

            public int getDecimalDigits() {  return 0; }
        };

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);
        dataSets.add(setComp3);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();
    }


}