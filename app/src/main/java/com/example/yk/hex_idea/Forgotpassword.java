package com.example.yk.hex_idea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Forgotpassword extends AppCompatActivity {

    private EditText  et_eml1;
    private String  eml1;
    Button sbmt;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

//        et_tw3 = (EditText)findViewById(R.id.fpsw);
        et_eml1 = (EditText) findViewById(R.id.eml1);

        sbmt = (Button) findViewById(R.id.sbmt);
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Forgotpassword.this, MainActivity.class);
                startActivity(i);

            }

        });
    }
}
