package com.example.a16046562.p05ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText ettitle, etsingerr,etyearr;
    RadioGroup rg;
    Button btninsert, btnshowlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ettitle = (EditText) findViewById(R.id.etsongtitle);
        etsingerr = (EditText) findViewById(R.id.etsingers);
        etyearr = (EditText) findViewById(R.id.etyear);
        btninsert = (Button) findViewById(R.id.btninsertsong);
        btnshowlist = (Button) findViewById(R.id.btnshowsong);
        rg = (RadioGroup) findViewById(R.id.radioGroupStars);

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ettitle.getText().toString();

            }
        });
        btnshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, Activity_show.class);
                startActivity(i);
            }
        });
    }
    private int getStars() {
        int stars = 1;
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.radio1:
                stars = 1;
                break;
            case R.id.radio2:
                stars = 2;
                break;
            case R.id.radio3:
                stars = 3;
                break;
            case R.id.radio4:
                stars = 4;
                break;
            case R.id.radio5:
                stars = 5;
                break;
        }
        return stars;
    }
}
