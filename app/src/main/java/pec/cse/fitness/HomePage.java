package pec.cse.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    private ImageView fitbtn, healthbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        fitbtn = findViewById(R.id.fitImg);
        healthbtn = findViewById(R.id.healthImg);
        fitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fitIntent = new Intent(HomePage.this, MainActivity.class);
                startActivity(fitIntent);
            }
        });

        healthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent healthIntent = new Intent(HomePage.this, HealthPage.class);
                startActivity(healthIntent);
            }
        });

    }
}