package com.example.aryawirasandi.uts_si3905_15_aryawirasandi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Home extends AppCompatActivity {
    TextView mTahun, mNama;
    int mYear;
    int myear;
    String namA, tAhun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNama = findViewById(R.id.NamaUser);
        mTahun = findViewById(R.id.thn);

        namA = getIntent().getStringExtra("nama");
        mNama.setText(namA);

        tAhun = getIntent().getStringExtra("yeAr");
        myear = Integer.parseInt(tAhun);

        Calendar now = Calendar.getInstance();
        mYear = now.get(Calendar.YEAR) - myear;

        mTahun.setText(String.valueOf(mYear));
    }
}
