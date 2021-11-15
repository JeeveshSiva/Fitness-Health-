package pec.cse.fitness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button  btnLogin;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.usernameLogin);
        password=(EditText)findViewById(R.id.passwordLogin);
        btnLogin=(Button)findViewById(R.id.btnLogin);

        myDB =new DBHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isConnected(LoginActivity.this)) {
                    showCustomDialog();
                }
                else

                {
                    Perform();
                }


            }
        });

    }

    private void Perform() {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.equals("") || pass.equals("")) {
            Toast.makeText(LoginActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();

        } else {
            Boolean result = myDB.checkusernamePassword(user, pass);
            if (result == true) {
                //Toast.makeText(LoginActivity.this,"successful",Toast.LENGTH_SHORT).show();
                Intent logIntent = new Intent(LoginActivity.this, HomePage.class);
                startActivity(logIntent);
            } else {
                Toast.makeText(LoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void showCustomDialog() {
        AlertDialog.Builder  builder = new AlertDialog.Builder(LoginActivity.this);

        builder.setMessage("Please Connect to the Internet for Further Process")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();




    }

    private boolean isConnected(LoginActivity loginActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager)loginActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);

        if((wifiConn!=null && wifiConn.isConnected() )|| (mobileConn!=null && mobileConn.isConnected())){

            return  true;
        }
        else
        {
            return false;
        }

    }
}