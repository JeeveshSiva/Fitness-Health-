package pec.cse.fitness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class HealthFragment extends Fragment {

    View v5;
    EditText sellerName, storeName, storeDescp, storeAddress;
    Button nextButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v5 = inflater.inflate(R.layout.fragment_health, container, false);
        sellerName = v5.findViewById(R.id.sellername);
        storeName = v5.findViewById(R.id.storename);
        storeDescp = v5.findViewById(R.id.details);
        storeAddress = v5.findViewById(R.id.address);
        nextButton = v5.findViewById(R.id.next12345);


        nextButton.setOnClickListener((v5) -> {
            Bundle bundle = new Bundle();
            bundle.putString("key1",sellerName.getText().toString());
            bundle.putString("key2",storeName.getText().toString());
            bundle.putString("key3",storeDescp.getText().toString());
            bundle.putString("key4",storeAddress.getText().toString());
            Health2Fragment fragment12345 = new Health2Fragment();
            fragment12345.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.frameLayoutjinx,fragment12345).addToBackStack(null).commit();
        });
        return v5;
    }
}