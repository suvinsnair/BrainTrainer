package com.example.suvin.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.view.View.*;
import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    ImageView imageView;
    TextView NumberView;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    Button buttons[];


    public void goClick(View view) {


        Log.i("Go Pressed", "Now");
        goButton.setVisibility(INVISIBLE);
        imageView.animate().translationXBy(1000f);
        generateNumbers();


    }

    public void generateNumbers(){


        Random random=new Random();

        int a=random.nextInt(40);
        int b=random.nextInt(40);

        NumberView.setText(a  + " + "+ b );
        int currentanswer=a+b;
        answers.add(currentanswer);

        int c=random.nextInt(60);
        while(currentanswer==c){
            c=random.nextInt(60);
        }
        answers.add(c);


        int d=random.nextInt(60);
        while(currentanswer==d){
            d=random.nextInt(60);
        }
        answers.add(d);

        int e =random.nextInt(60);

        while(currentanswer==e){
            e=random.nextInt(60);
        }

        answers.add(e);
        int f=random.nextInt(4);
        buttons[f].setText(valueOf(currentanswer));



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        goButton = (Button) findViewById(R.id.goButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        NumberView =(TextView) findViewById(R.id.NumberView);

        Button buttons[] = new Button[4];

        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);





    }



}
