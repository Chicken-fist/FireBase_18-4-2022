package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText edtYourName, edtEmail, edtPass, edtPassRecheck;
    private ImageButton btnRegister;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edtEmail);
        edtYourName = findViewById(R.id.edtYourName);
        edtPass = findViewById(R.id.edtPass1);
        edtPassRecheck = findViewById(R.id.edtPass2);
        btnRegister = findViewById(R.id.btnRegisterInRegister);

        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String yourName = edtYourName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String password1 = edtPass.getText().toString().trim();
                String password2 = edtPassRecheck.getText().toString().trim();

                if(yourName.equals("")){
                    Toast.makeText(Register.this, "Xin hãy nhập tên của bạn",
                            Toast.LENGTH_SHORT).show();
                }
                else if(email.equals("")){
                    Toast.makeText(Register.this, "Xin hãy nhập email của bạn",
                            Toast.LENGTH_SHORT).show();
                }
                else if(password1.equals("")){
                    Toast.makeText(Register.this, "Xin hãy nhập password của bạn",
                            Toast.LENGTH_SHORT).show();
                }
                else if(password2.equals("")){
                    Toast.makeText(Register.this, "Xin hãy nhập password của bạn lại lần nữa",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!password1.equals(password2)){
                        Toast.makeText(Register.this, "Cả 2 password phải giống nhau",
                                Toast.LENGTH_SHORT).show();
                    }
                    else{
                        mAuth.createUserWithEmailAndPassword(email, password1)
                                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            Intent intent = new Intent(Register.this, Sign_in.class);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(Register.this, "Đăng ký thất bại",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });
    }
}