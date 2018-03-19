package com.example.aryawirasandi.uts_si3905_15_aryawirasandi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText mUser, mTanggal, mTahun, mPassword;
    Button mNext;
    Spinner mSpinner;
    String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mTanggal = findViewById(R.id.tanggal);
        mTahun = findViewById(R.id.tahun);

        mNext = findViewById(R.id.BtnSignUP);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                myAlertBuilder.setTitle("Alert");
                myAlertBuilder.setMessage("Sudah yakin datanya benar?");

//              Untuk tombol positive
                myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(MainActivity.this, Login.class);
                        String user = mUser.getText().toString();
                        String pass = mPassword.getText().toString();
                        String tahun = mTahun.getText().toString();

                        i.putExtra("User", user);
                        i.putExtra("Pass", pass);
                        i.putExtra("Tahun", tahun);
                        startActivity(i);
                    }
                });
//              Untuk tombol Negative
                myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Proses Dibatalkan", Toast.LENGTH_SHORT).show();
                    }
                });
                myAlertBuilder.show();
            }
        });
        mSpinner = findViewById(R.id.combobox);
        if(mSpinner != null){
            mSpinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bulan,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(mSpinner != null){
            mSpinner.setAdapter(adapter);
        }
    }
    public void onRadionButtonClicked(View view){
        switch (view.getId()){
            case R.id.Lk:
                Toast.makeText(this, "Pria Dipilih", Toast.LENGTH_SHORT).show();
            break;
            case R.id.Pr:
                Toast.makeText(this, "Perempuan", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerLabel = parent.getItemAtPosition(position).toString();
        String showString = mSpinnerLabel;
        Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
