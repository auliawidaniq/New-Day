package com.example.movi.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movi.Models.UserHelperClass;
import com.example.movi.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button callSignIn, callSignUp;
    TextInputLayout requsername, reqemail, reqpassword;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        callSignIn = findViewById(R.id.reg_login_btn);
        callSignUp = findViewById(R.id.bt_signup);
        requsername = findViewById(R.id.username);
        reqemail = findViewById(R.id.email);
        reqpassword = findViewById(R.id.password);

        callSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String username = requsername.getEditText().getText().toString();
                String email = reqemail.getEditText().getText().toString();
                String password = reqpassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(username, email, password);
                reference.child(username).setValue(helperClass);

                Intent intent = new Intent(SignUp.this, HomeActivity.class);
                startActivity(intent);



            }
        });


    }

}