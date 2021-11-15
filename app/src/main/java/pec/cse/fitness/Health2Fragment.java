package pec.cse.fitness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Health2Fragment extends Fragment {

    View v6;
    int h,w;
    double bmivalue;
        float hh;
    TextView sellName,stName,stDes,stAdd,bmitxt;
    Button finishB;
    String bmiresult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v6 =  inflater.inflate(R.layout.fragment_health2, container, false);
        sellName = v6.findViewById(R.id.sellllllname);
        stName = v6.findViewById(R.id.storeeeename);
        stDes = v6.findViewById(R.id.dettaaillss);
        stAdd = v6.findViewById(R.id.adddreesss);
        bmitxt=v6.findViewById(R.id.bmivaluetext);
        Bundle bundle = getArguments();
        String data1 = bundle.getString("key1");
        String data2 = bundle.getString("key2");
        String data3 = bundle.getString("key3");
        String data4 = bundle.getString("key4");
        sellName.setText(data1);
        stName.setText(data2);
        stDes.setText(data3);
        stAdd.setText(data4);
        h=Integer.parseInt(data1);
        w=Integer.parseInt(data2);
        bmivalue= (w*h);

        bmiresult=String.valueOf(bmivalue);
        bmitxt.setText(bmiresult);


        finishB = v6.findViewById(R.id.finish12345);
        finishB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmivalue>=1500){
                    Toast.makeText(getContext(), "you are obese " + bmiresult,Toast.LENGTH_SHORT).show();

                } else {


                    Toast.makeText(getContext(), "You are lean ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v6;
    }
}