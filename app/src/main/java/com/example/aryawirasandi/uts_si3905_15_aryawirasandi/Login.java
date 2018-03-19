package com.example.aryawirasandi.uts_si3905_15_aryawirasandi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText user, pass;
    Button login;
    String Namausr, Katasandi, Usernama, Pass, Year;
    Intent move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.User);
        pass = findViewById(R.id.passWord);
        login = findViewById(R.id.btnLogin);

        Intent i = getIntent();

        Usernama = getIntent().getStringExtra("User");
        Pass = getIntent().getStringExtra("Pass");
        Year = getIntent().getStringExtra("Tahun");

        user.setText(Usernama);
        pass.setText(Pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Namausr = user.getText().toString();
                Katasandi = pass.getText().toString();

                if(Namausr.equals(Usernama) && Katasandi.equals(Pass) ){
                    Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    move = new Intent(Login.this, Home.class);
                    move.putExtra("yeAr", Year);
                    move.putExtra("nama", Usernama);
                    startActivity(move);
                }else{
                    Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
