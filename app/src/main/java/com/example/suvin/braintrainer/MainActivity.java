package com.example.suvin.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.view.View.*;
import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    ImageView imageView;
    TextView question;
    TextView timer;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    int number=1;
    int locationanswer;
    TextView finishview;

    TextView NumberView;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int score=0;



    public void buttonPressed(View view){
        System.out.println(view.getTag());

        if(Integer.toString(locationanswer).equals(view.getTag().toString())){
            score++;

            Toast.makeText(this, "CORRECT !!!..", Toast.LENGTH_SHORT).show();
            question.setText(Integer.toString(score) + " / " +  Integer.toString(number));
            answers.clear();
            generateNumbers();



        }
        else{
            Toast.makeText(this, "SORRY   !!!..", Toast.LENGTH_SHORT).show();
            question.setText(Integer.toString(score) + " / " + Integer.toString(number));
            answers.clear();
            generateNumbers();




        }



    }


    public void goClick(View view) {

        NumberView.setVisibility(VISIBLE);
        question.setVisibility(VISIBLE);
        timer.setVisibility(VISIBLE);
        button1.setVisibility(VISIBLE);
        button2.setVisibility(VISIBLE);
        button3.setVisibility(VISIBLE);
        button4.setVisibility(VISIBLE);
        question.setText(Integer.toString(0) + " / " +  Integer.toString(1));



        Log.i("Go Pressed", "Now");
        goButton.setVisibility(INVISIBLE);
        imageView.animate().translationXBy(1000f).setDuration(1200);
        generateNumbers();

        new CountDownTimer(30100, 1000){


            @Override
            public void onTick(long l) {

                timer.setText((String.valueOf(l/1000)) + " s");
            }

            @Override
            public void onFinish() {

                timer.setText("0 s ");

                finishview.setVisibility(VISIBLE);


            }
        }.start();


    }

    public void generateNumbers(){


        Random random=new Random();
        number++;

        int a=random.nextInt(20);
        int b=random.nextInt(20);

        NumberView.setText(a  + " + "+ b );
        int currentanswer=a+b;
        locationanswer=random.nextInt(4);
        int incorrectans=random.nextInt(40);

        for(int i=0; i<4; i++){

            if(locationanswer==i){

                answers.add(currentanswer);
            }
            else{
                incorrectans=random.nextInt(40);
                while(currentanswer==incorrectans){

                    incorrectans=random.nextInt(40);

                }
                answers.add(incorrectans);


            }
        }
        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        goButton = (Button) findViewById(R.id.goButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        NumberView =(TextView) findViewById(R.id.NumberView);
        question =(TextView) findViewById(R.id.question);
        timer =(TextView) findViewById(R.id.timer);
        button1 =(Button)findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 =(Button)findViewById(R.id.button3);
        button4 =(Button)findViewById(R.id.button4);
        finishview=(TextView)findViewById(R.id.finishview);





    }



}
