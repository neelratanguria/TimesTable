package com.flameshot.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayAdapter<Integer> arrayAdapter;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i <=20;i++)
        {
            arrayList.add(i*1);
        }

        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);
        

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        seekBar.setMax(99);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                arrayList.clear();
                for (int i = 1; i <=20;i++)
                {
                    arrayList.add(i*(progress+1));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
            }
        });
    }
}
