 package pec.cse.fitness;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity3 extends AppCompatActivity {
 EditText username,email,password,repassword;
 Button btnSignup,btnSignin;
 Button btn;

 DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        username=(EditText)findViewById(R.id.username);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);


        btn=findViewById(R.id.btnSignin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(i);
            }
        });

        btnSignup=(Button)findViewById(R.id.btnSignup);
        btnSignin=(Button)findViewById(R.id.btnSignin);
        myDB =new DBHelper(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();
                 if(user.equals("")||mail.equals("")||pass.equals("")||repass.equals(""))
                 {
                     Toast.makeText(MainActivity3.this,"fill all the fields",Toast.LENGTH_SHORT).show();

                 }
                 else
                 {
                     if(pass.equals(repass))
                     {
                       Boolean userCheckResult=myDB.checkusername(user);
                       if(userCheckResult==false)
                       {
                        Boolean regResult=myDB.insertData(user,mail,pass,repass);
                        if(regResult==true)
                        {
                            Toast.makeText(MainActivity3.this,"Registration Successful",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(MainActivity3.this,"registration failed",Toast.LENGTH_SHORT).show();
                        }
                       }
                       else
                       {
                           Toast.makeText(MainActivity3.this,"User already exists.\n Please sign in",Toast.LENGTH_SHORT).show();
                       }
                     }
                     else
                     {
                         Toast.makeText(MainActivity3.this,"password not matching",Toast.LENGTH_SHORT).show();
                     }

                 }

            }


        });
    }
}