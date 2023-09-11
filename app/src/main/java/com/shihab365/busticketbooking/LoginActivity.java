package com.shihab365.busticketbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText etLogEmail, etLogPassword;
    TextView tvBtnCreate;
    FirebaseAuth firebaseAuth;
    String strLogEmail, strLogPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnSignIn = findViewById(R.id.btn_signInID);
        etLogEmail = findViewById(R.id.logEmailID);
        etLogPassword = findViewById(R.id.logPasswordID);
        tvBtnCreate = findViewById(R.id.tv_CreateAccountID);

        firebaseAuth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strLogEmail = etLogEmail.getText().toString().trim();
                strLogPassword = etLogPassword.getText().toString().trim();

                if(!strLogEmail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(strLogEmail).matches()){
                    if(!strLogPassword.isEmpty()){
                        firebaseAuth.signInWithEmailAndPassword(strLogEmail, strLogPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
                                intent.putExtra("email", etLogEmail.getText().toString());
                                startActivity(intent);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Login Failed! Try again.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });

        tvBtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
            }
        });
    }
}