package pec.cse.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HealthPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_page);
        //nextButton = findViewById(R.id.nextokay);
        //replaceFragment(new profile1Fragment());
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutjinx, new HealthFragment()).commit();
        //nextButton.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //replaceFragment(new profile2Fragment());
        //}
        //});

    }
}