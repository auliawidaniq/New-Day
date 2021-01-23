package com.example.movi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.movi.Models.UserHelperClass;
import com.example.movi.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    TextInputLayout requsername, reqpassword, reqemail;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String _USERNAME, _EMAIL, _PASSWORD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        requsername = findViewById(R.id.username);
        reqpassword = findViewById(R.id.password);


showAllUserData();
    }

    private void showAllUserData() {

        Intent intent = getIntent();
        _USERNAME = intent.getStringExtra("username");
        _PASSWORD = intent.getStringExtra("password");

        requsername.getEditText().setText(_USERNAME);
        reqpassword.getEditText().setText(_PASSWORD);

    }

    public void Back(View view){
        Intent intent = new Intent(Profile.this, HomeActivity.class);
        startActivity(intent);
    }

    public void Delete(View view){
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        String username = requsername.getEditText().getText().toString();
        String password = reqpassword.getEditText().getText().toString();

        reference.child(username).removeValue();
        Toast.makeText(this, "Successfully deleted user", Toast.LENGTH_LONG).show();

        requsername.getEditText().setText("");
        reqpassword.getEditText().setText("");

    }

    public void update(View view){
        String username = requsername.getEditText().getText().toString();
        String password = reqpassword.getEditText().getText().toString();

        if(!TextUtils.isEmpty(username) || !TextUtils.isEmpty(password)  ){
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            reference.child(username).setValue(username);
            reference.child(username).setValue(password);

            requsername.getEditText().toString();
            reqpassword.getEditText().toString();

            Toast.makeText(this, "Data has been updated", Toast.LENGTH_LONG).show();
        }else
        Toast.makeText(this, "Data is same can not be updated", Toast.LENGTH_LONG).show();
    }


}
