package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        SeekBar seekB;

    ListView listView;




      public void tabless(int position)                                                                                   
      {
           ArrayList<String> arrayList=new ArrayList<String>(); 
          int gan;                                                                                                        
          for(int i=1;i<=10;i++)                                                                                          
          {                                                                                                               
              gan=i*position;                                                                                             
              arrayList.add(Integer.toString(gan));                                                                       
          }                                                                                                               
          ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);      
          listView.setAdapter(adapter);                                                                                   
      }                                                                                                                   
                                                                                                                          



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekB=(SeekBar)findViewById(R.id.seekBar);
       listView=(ListView)findViewById(R.id.list);

        int max=20;
        seekB.setMax(max);
        seekB.setProgress(10);
        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int times;
                if(progress<min)
                {
                    times=min;
                    seekBar.setProgress(min);
                }
                else
                {
                    times=progress;
                    Log.i("Seel",Integer.toString(progress));

                }
                tabless(times);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tabless(10);


    }











}
