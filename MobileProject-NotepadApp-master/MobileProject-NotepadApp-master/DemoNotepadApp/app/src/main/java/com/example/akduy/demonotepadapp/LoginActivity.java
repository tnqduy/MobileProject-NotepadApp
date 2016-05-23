package com.example.akduy.demonotepadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin, btnExit, btnSignup;
    TextView txtUsername, txtPassword;
    UserVerificationHelper _uvHelper;//To check user login
    LoginFormatHelper _lfHelpher; //To check user login format
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        _uvHelper = new UserVerificationHelper();
        _lfHelpher = new LoginFormatHelper();

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnExit = (Button)findViewById(R.id.btnExit);
        btnSignup = (Button)findViewById(R.id.btnSignup);
        txtPassword = (TextView)findViewById(R.id.txtPassword);
        txtUsername = (TextView)findViewById(R.id.txtUsername);

        btnLogin.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnLogin.getId())
        {
            String checkResult = _lfHelpher.FormatCheck(txtUsername.getText().toString(), txtPassword.getText().toString());
            if (checkResult == "")
            {
                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();
            }
            else
            {
                Toast.makeText(this,checkResult, Toast.LENGTH_SHORT);
            }
            //If username and password is matched, navigate user to the MainUI
            if (_uvHelper.VerifyUser(txtUsername.getText().toString(),txtPassword.getText().toString()))
            {
                NavigateToMainUI(username,password);
            }
            else //Notify user about wrong login
            {
                Toast.makeText(this,"Username or password is not valid", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == btnExit.getId())
        {
            //Exit the app
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if (v.getId() == btnSignup.getId())
        {
            Toast.makeText(this,"This is a dummy text", Toast.LENGTH_SHORT).show();
        }
    }

    private void NavigateToMainUI(String username, String password) {
        Intent mIntent = new Intent(this, MainActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString(username,"<Username>");
        mBundle.putString(password,"<Password>");

        startActivity(mIntent);
    }
}
