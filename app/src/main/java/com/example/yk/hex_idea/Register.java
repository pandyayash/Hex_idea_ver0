package com.example.yk.hex_idea;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yk.hex_idea.tabfragment.applicationhepler.HttpExecutor;
import com.example.yk.hex_idea.tabfragment.applicationhepler.URLConstatn;

import org.json.JSONObject;


public class Register extends AppCompatActivity {
    TextView t2;
    Button b;
    private EditText userName;
    private EditText email;
    private EditText cPassword;
    private EditText phone;
    private EditText etPassword;
    private TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        t2 = (TextView) findViewById(R.id.textView2);

        userName = (EditText) findViewById(R.id.etUserNmae);
        email = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassWord);
        cPassword = (EditText) findViewById(R.id.etConfirmPassword);
        phone = (EditText) findViewById(R.id.etPhone);
        skip=(TextView)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

        b = (Button) findViewById(R.id.btn2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().length()==0){
                    userName.setText("Please enter username");
                }else if (email.getText().toString().length()==0){
                    email.setText("Please enter email-address");
                }else if (etPassword.getText().toString().length()==0){
                    etPassword.setText("Please enter password");
                }else if (cPassword.getText().toString().length()==0){
                    cPassword.setText("Please confirm password");
                }else if(phone.getText().toString().length()==0){
                    phone.setText("Please ennter your phone number");
                }else {

                    JSONObject requestParam = new JSONObject();
                    try {
                        requestParam.put("full_name", userName.getText().toString());
                        requestParam.put("email", email.getText().toString());
                        requestParam.put("mobile", phone.getText().toString());
                        requestParam.put("password", etPassword.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    HttpExecutor httpExecutor = new HttpExecutor();
                    httpExecutor.httpPost(requestParam, URLConstatn.REGISTER_URL, Register.this);

                    Intent i = new Intent(Register.this, Login.class);
                    startActivity(i);
                    finish();
                }
            }
        });


    }

}
/*
    private void registerCall() {

            JSONObject jsonParams = new JSONObject();
           try {
                jsonParams.put("actionId", 1);
                jsonParams.put("merriageId", 101);
                jsonParams.put("deviceId", deviceId);
                jsonParams.put("name", God.userName);
                jsonParams.put("email", God.email);
                jsonParams.put("mobile", God.mobileNo);
                jsonParams.put("acceptation", str);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity entity = null;
            try {
                entity = new StringEntity(jsonParams.toString());

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            client = new AsyncHttpClient();
            client.post(Invitation.this, God.URL, entity, "application/json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    God.dismissDialog(Invitation.this);

                    String strResponnse = new String(responseBody);

                    Log.e("res", strResponnse);
                    Toast.makeText(Invitation.this, "" + strResponnse, Toast.LENGTH_LONG).show();
                    gson = new Gson();

                    SharedPreferences.Editor editor = getSharedPreferences("user", 0).edit();
                    editor.putString("deviceid", deviceId);
                    editor.apply();
                    editor.commit();

                    Intent intent = new Intent(Invitation.this, NewMenu.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                    progressDialog.dismiss();
                    God.dismissDialog(Invitation.this);
                }
            });
        }*/


