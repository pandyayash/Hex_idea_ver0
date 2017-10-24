package com.example.yk.hex_idea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yk.hex_idea.tabfragment.applicationhepler.URLConstatn;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    EditText userNmae, password;
    TextView registerview,forgotview;
    private Button loginBtn;
    int checklogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerview= (TextView) findViewById(R.id.twregister);
        registerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
                finish();
            }
        });
        forgotview= (TextView) findViewById(R.id.twforgot);
        forgotview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Forgotpassword.class);
                startActivity(intent);
            }
        });


        loginBtn = (Button) findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNmae = (EditText) findViewById(R.id.etEmail);
                password = (EditText) findViewById(R.id.etPassWord);
                if (userNmae.getText().toString().length() == 0) {
                    userNmae.setError("Username is required");
                } else if(password.getText().toString().length()==0){
                    password.setError("Password is required");
                }else {
                    JSONObject jasonparam = new JSONObject();
                    try {
                        jasonparam.put("email", userNmae.getText().toString());
                        jasonparam.put("password", password.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.d("httpPost()", "Enter in httpPost-->");
                    StringEntity stringEntity = null;
                    try {
                        stringEntity = new StringEntity(jasonparam.toString());
                        stringEntity.setContentType("application/json");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AsyncHttpClient client = new AsyncHttpClient();

                    client.post(Login.this, URLConstatn.LOGIN_URL, stringEntity, "application/json", new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            String responsce = new String(responseBody);
                            int cheklogin = 0;
                            try {
                                JSONObject jsonobject = new JSONObject(responsce);
                                cheklogin = jsonobject.getInt("success");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (cheklogin == 1) {

                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login.this, "Login failed", Toast.LENGTH_LONG).show();
                            }
                            Log.d("Responsce on Sucess ", "" + statusCode + " Respnsce ::: " + responsce);
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            Log.d("Responsce on Failer ", "" + statusCode);
                        }
                    });
                }
            }

        });
    }
}

