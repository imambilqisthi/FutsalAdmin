package com.example.futsaladmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText ETUserMail,ETPassword;
    private CheckBox CBPassword;
    private Button BTNLogin;
    private FirebaseAuth mAuth;
    private Intent homeAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ETUserMail = findViewById(R.id.ETUserMail);
        ETPassword = findViewById(R.id.ETPassword);
        CBPassword = findViewById(R.id.CBPassword);
        BTNLogin = findViewById(R.id.BTNLogin);
        mAuth = FirebaseAuth.getInstance();
        homeAct = new Intent(this,HomeActivity.class);
        CBPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CBPassword.isChecked()) {
                    ETPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    ETPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        BTNLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTNLogin.setVisibility(View.VISIBLE);


                final String mail = ETUserMail.getText().toString();
                final String password = ETPassword.getText().toString();

                if (mail.isEmpty()||password.isEmpty()){
                    showmessage("Email dan Kata Sandi Tidak Boleh Kosong");
                }else{
                    sigIn(mail,password);
                }

            }
        });
    }

    private void sigIn(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    BTNLogin.setVisibility(View.VISIBLE);
                    updateUI();
                }else{
                    Toast.makeText(LoginActivity.this,"Pastikan Email, Kata Sandi Benar dan Pastikan Perangkat Terhubung Dengan Internet",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateUI() {
        startActivity(homeAct);
        finish();
    }

    private void showmessage(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }
}