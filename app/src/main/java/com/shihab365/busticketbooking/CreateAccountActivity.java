package com.shihab365.busticketbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {
    EditText etRegName, etRegEmail, etRegPassword;
    Button btnSignUp;
    String strRegName, strRegEmail, strRegPassword;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnSignUp = findViewById(R.id.btn_SignUpID);
        etRegName = findViewById(R.id.regNameID);
        etRegEmail = findViewById(R.id.regEmailID);
        etRegPassword = findViewById(R.id.regPasswordID);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strRegName = etRegName.getText().toString().trim();
                strRegEmail = etRegEmail.getText().toString().trim();
                strRegPassword = etRegPassword.getText().toString().trim();
                if(strRegEmail.isEmpty()){
                    Toast.makeText(CreateAccountActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                if(strRegPassword.isEmpty()){
                    Toast.makeText(CreateAccountActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.createUserWithEmailAndPassword(strRegEmail, strRegPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                UserProfile();
                                startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));
                            }else{
                                Toast.makeText(CreateAccountActivity.this, "SignUp Failed! Try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    private void UserProfile() {
        Map<String, String> userProfile = new HashMap<>();
        userProfile.put("Name", strRegName);
        userProfile.put("Email", strRegEmail);
        userProfile.put("Password", strRegPassword);

        firestore.collection("UserProfile").document(strRegEmail).set(userProfile).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        });

    }
}