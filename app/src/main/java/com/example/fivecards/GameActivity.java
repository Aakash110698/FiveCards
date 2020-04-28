package com.example.fivecards;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    ArrayList<String> names;
    ArrayList<TextView> nameP,values,getValues;
    ArrayList<Integer> score;
    Button add;
    //TextView nameP1,nameP2,nameP3,nameP4,nameP5,nameP6,nameP7,nameP8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        nameP=new ArrayList<TextView>();
        values=new ArrayList<TextView>();
        getValues=new ArrayList<TextView>();
        score=new ArrayList<>();
        nameP.add((TextView)findViewById(R.id.p1name));
        nameP.add((TextView)findViewById(R.id.p2name));
        nameP.add((TextView)findViewById(R.id.p3name));
        nameP.add((TextView)findViewById(R.id.p4name));
        nameP.add((TextView)findViewById(R.id.p5name));
        nameP.add((TextView)findViewById(R.id.p6name));
        nameP.add((TextView)findViewById(R.id.p7name));
        nameP.add((TextView)findViewById(R.id.p8name));
        values.add((TextView)findViewById(R.id.p1pointvalue));
        values.add((TextView)findViewById(R.id.p2pointvalue));
        values.add((TextView)findViewById(R.id.p3pointvalue));
        values.add((TextView)findViewById(R.id.p4pointvalue));
        values.add((TextView)findViewById(R.id.p5pointvalue));
        values.add((TextView)findViewById(R.id.p6pointvalue));
        values.add((TextView)findViewById(R.id.p7pointvalue));
        values.add((TextView)findViewById(R.id.p8pointvalue));
        getValues.add((TextView)findViewById(R.id.p1point));
        getValues.add((TextView)findViewById(R.id.p2point));
        getValues.add((TextView)findViewById(R.id.p3point));
        getValues.add((TextView)findViewById(R.id.p4point));
        getValues.add((TextView)findViewById(R.id.p5point));
        getValues.add((TextView)findViewById(R.id.p6point));
        getValues.add((TextView)findViewById(R.id.p7point));
        getValues.add((TextView)findViewById(R.id.p8point));
        add=(Button)findViewById(R.id.add);
        names=new ArrayList<String>();
        names=getIntent().getStringArrayListExtra("names");
        final int target=getIntent().getIntExtra("target",0);
        for(int i=0;i<names.size();i++)
        {
            nameP.get(i).setText(names.get(i));
            score.add(0);
        }


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    for(int i=0;i<names.size();i++)
                    {
                        if (target>score.get(i)) {
                            score.set(i, score.get(i) + Integer.parseInt(getValues.get(i).getText().toString()));
                                if (target > score.get(i)) {
                                    values.get(i).setText(Integer.toString(score.get(i)));
                                } else {
                                    Toast.makeText(getApplicationContext(), "player " + names.get(i) + " is lost", Toast.LENGTH_SHORT).show();
                                    values.get(i).setText(Integer.toString(score.get(i)));
                                }
                        }
                    }
            }
        });

        //int num=names.size();
       // Toast.makeText(getApplicationContext(),Integer.toString(num),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
