package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {

    private EditText edtEmail, edtPass;
    private ImageButton btnSignIn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        edtEmail = findViewById(R.id.edtEmailSignin);
        edtPass = findViewById(R.id.edtPassSignin);
        btnSignIn = findViewById(R.id.btnSigninInSignIn);

        mAuth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String email = edtEmail.getText().toString().trim();
                    String pass = edtPass.getText().toString().trim();

                    if(email == null){
                        Toast.makeText(Sign_in.this, "Xin Hãy nhập email của bạn.",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(pass == null){
                        Toast.makeText(Sign_in.this, "Xin Hãy nhập Password của bạn.",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        mAuth.signInWithEmailAndPassword(email, pass)
                                .addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            Intent intent = new Intent(Sign_in.this, Face.class);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(Sign_in.this, "Email hoặc Password không đúng!",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
            }
        });

    }
}
