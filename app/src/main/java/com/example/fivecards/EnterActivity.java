package com.example.fivecards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterActivity extends AppCompatActivity {
     int num;
     TextView nameP1,nameP2,nameP3,nameP4,nameP5,nameP6,nameP7,nameP8;
     Button button;
    ArrayList<TextView> nameP;
     ArrayList<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        nameP=new ArrayList<TextView>();
        nameP.add((TextView)findViewById(R.id.player1name));
        nameP.add((TextView)findViewById(R.id.player2name));
        nameP.add((TextView)findViewById(R.id.player3name));
        nameP.add((TextView)findViewById(R.id.player4name));
        nameP.add((TextView)findViewById(R.id.player5name));
        nameP.add((TextView)findViewById(R.id.player6name));
        nameP.add((TextView)findViewById(R.id.player7name));
        nameP.add((TextView)findViewById(R.id.player8name));
        button=(Button)findViewById(R.id.start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=getIntent().getIntExtra("noPlayers",0);
                int target=getIntent().getIntExtra("target",0);
                int flag=0;
                names=new ArrayList<>();
                for(int i=0;i<num;i++) {
                    if (!nameP.get(i).getText().toString().equals("")) {
                        names.add(nameP.get(i).getText().toString());
                    } else {
                        flag=1;
                        Toast.makeText(getApplicationContext(), "please fill the player name", Toast.LENGTH_SHORT).show();
                    }
                }
                if(flag==0) {
                    Intent it = new Intent(getApplicationContext(), GameActivity.class);
                    it.putStringArrayListExtra("names", names);
                    it.putExtra("target", target);
                    startActivity(it);
                }
                //Toast.makeText(getApplicationContext(),Integer.toString(names.size()),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
