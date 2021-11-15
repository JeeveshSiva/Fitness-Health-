package pec.cse.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
public class workoutActivity extends AppCompatActivity {

TextView titlepage,subtitlepage,intropage,subintropage,btnexercise ,fitonetitle,fittwotitle,fitthreetitle,fitfourtitle,fitonedesc,fittwodesc,fitthreedesc,fitfourdesc;
View divpage,btnprogress;
Animation button,button2,buttonfour,button5,button6,button7,button8;
LinearLayout fitone,fittwo,fitthree,fitfour;
Button b1;
Button b2;
Button b3;
Button b4;
Button b5;
Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        button=AnimationUtils.loadAnimation(this,R.anim.button);
        button2=AnimationUtils.loadAnimation(this,R.anim.button2);
        buttonfour=AnimationUtils.loadAnimation(this,R.anim.buttonfour);
        button5=AnimationUtils.loadAnimation(this,R.anim.button5);
        button6=AnimationUtils.loadAnimation(this,R.anim.button6);
        button7=AnimationUtils.loadAnimation(this,R.anim.button7);
        button8=AnimationUtils.loadAnimation(this,R.anim.button8);

        b1=findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(workoutActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        b2=findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(workoutActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        b3=findViewById(R.id.btn3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(workoutActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        b4=findViewById(R.id.btn4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(workoutActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        b5=findViewById(R.id.buttonalarm);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(workoutActivity.this,SelectActivity.class);
                startActivity(i);
            }
        });

        test = findViewById(R.id.button2);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(workoutActivity.this,Music.class);
                startActivity(intent);
            }
        });

        titlepage=(TextView)findViewById(R.id.titlepage);
        subtitlepage=(TextView)findViewById(R.id.subtitlepage);
       intropage=(TextView)findViewById(R.id.intropage);
        subintropage=(TextView)findViewById(R.id.subintropage);
        btnexercise=(TextView)findViewById(R.id.btnexercise);
        fitonetitle=(TextView)findViewById(R.id.fitonetitle);
        fitonedesc=(TextView)findViewById(R.id.fitonedesc);
        fittwotitle=(TextView)findViewById(R.id.fittwotitle);
        fittwodesc=(TextView)findViewById(R.id.fittwodesc);
        fitthreetitle=(TextView)findViewById(R.id.fitthreetitle);
        fitthreedesc=(TextView)findViewById(R.id.fitthreedesc);
        fitfourtitle=(TextView)findViewById(R.id.fitfourtitle);
        fitfourdesc=(TextView)findViewById(R.id.fitfourdesc);

        fitone=(LinearLayout)findViewById(R.id.fitone);
        fittwo=(LinearLayout)findViewById(R.id.fittwo);
        fitthree=(LinearLayout)findViewById(R.id.fitthree);
        fitfour=(LinearLayout)findViewById(R.id.fitfour);



        divpage=(View)findViewById(R.id.divpage);
        btnprogress=(View)findViewById(R.id.btnprogress);

        titlepage.startAnimation(button);
        subtitlepage.startAnimation( button);
        divpage.startAnimation(button);

        intropage.startAnimation(button2);
        subintropage.startAnimation(button2);

        fitone.startAnimation(button2);
        fittwo.startAnimation(buttonfour);
        fitthree.startAnimation(button5);
        fitfour.startAnimation(button6);

        btnexercise.startAnimation(button8);
        btnprogress.startAnimation(button7);



    }

}