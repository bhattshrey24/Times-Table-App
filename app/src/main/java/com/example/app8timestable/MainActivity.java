package com.example.app8timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void timesTableGenerator(int timesTableNumber){
        ArrayList<String> timesArrayList= new ArrayList<>();
        for(int j=1;j<=20;j++){
            timesArrayList.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesArrayList);
    listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=(SeekBar) findViewById(R.id.tableSeekBar);
        listView=(ListView) findViewById(R.id.tableListView);
        int initialTable=10;
        seekBar.setMax(20); //  that 100% of seekbar means 20 ki table
        seekBar.setProgress(10);// that is when app starts seekbar will be at 10s table
        timesTableGenerator(initialTable);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min =1;
                int timesTableNumber;
                if(i<min){
                    timesTableNumber=min;
                    seekBar.setProgress(i);
                }else{
                    timesTableNumber=i;
                }
                timesTableGenerator(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}