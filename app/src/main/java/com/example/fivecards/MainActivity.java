package com.example.fivecards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button enter;
    TextView noPlayers,target;
    int noplayers,targets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter=(Button)findViewById(R.id.enterBtn) ;
        noPlayers=(TextView) findViewById(R.id.noofplayers);
        target=(TextView)findViewById(R.id.targetvalue);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noplayers= Integer.parseInt(noPlayers.getText().toString());
                targets=Integer.parseInt(target.getText().toString());
                if(noplayers<2 && noplayers>8)
                {
                    Toast.makeText(getApplicationContext(),"players num inbetween 2 to 8",Toast.LENGTH_SHORT).show();
                }
                else if (targets<100 && targets>800)
                {
                    Toast.makeText(getApplicationContext(),"players num inbetween 200 to 800",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent it = new Intent(getApplicationContext(), EnterActivity.class);
                    it.putExtra("noPlayers", noplayers);
                    it.putExtra("target", targets);
                    startActivity(it);
                }
            }
        });
    }

     //hello



}
