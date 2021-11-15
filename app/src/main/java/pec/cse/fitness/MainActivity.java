package pec.cse.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
   TextView titlepage,btnexercise;
   ImageView imgpage;
   Animation animimgpage,button,button2,button3,lefttoright;
   View btnprogress,btnprogressstop;
    //Button btnstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titlepage=(TextView)findViewById(R.id.titlepage);
        btnexercise=(TextView)findViewById(R.id.btnexercise);
        animimgpage= AnimationUtils.loadAnimation(this,R.anim.animimgpage);
        button= AnimationUtils.loadAnimation(this,R.anim.button);
        button2= AnimationUtils.loadAnimation(this,R.anim.button2);
        button3= AnimationUtils.loadAnimation(this,R.anim.button3);
        lefttoright= AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        imgpage=(ImageView)findViewById(R.id.imgpage);
        btnprogress=(View)findViewById(R.id.btnprogress);
        btnprogressstop=(View)findViewById(R.id.btnprogressstop);

       // btnstart = findViewById(R.id.start);
        //btnstart.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
          //      Intent intent = new Intent(MainActivity.this,SelectActivity.class);
          //      startActivity(intent);
         //   }
       // });


        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(button);
        btnexercise.startAnimation(button3);
       btnprogress.startAnimation(button2);
        btnprogressstop.startAnimation(lefttoright);
        btnexercise.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                     Intent a = new Intent(MainActivity.this,workoutActivity.class);
                     //startActivity(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                     startActivity(a);
        }

            //private void startActivity(int flagActivityNoAnimation) {
            });



        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView1 = findViewById(R.id.imageView2);
        ImageView imageView2 = findViewById(R.id.imageView3);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=vairam fitness"));
                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]
                        {"buvanakarthik44@pec.edu"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"FEEDBACK");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose Mail App"));
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="9500659463";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(("tel:"+s)));
                startActivity(intent);
            }
        });



    }

}