package com.freelance.android.mvp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.freelance.android.mvp.R;
import com.freelance.android.mvp.model.ModelPresenterImpl;
import com.freelance.android.mvp.presenter.LoginPresenter;
import com.freelance.android.mvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private static final String LOG_TAG = LoginActivity.class.getName();

    LoginPresenter mLoginPresenter;
    EditText etUserName, etPassword;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST : onCreate() is called...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = this.findViewById(R.id.etUserName);
        etPassword = this.findViewById(R.id.etPassword);
        tvLogin = this.findViewById(R.id.tvLogin);
        mLoginPresenter = new ModelPresenterImpl(LoginActivity.this);

        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.i(LOG_TAG, "TEST : onClick() is called...");

        String userName = etUserName.getText().toString();
        String pwd = etPassword.getText().toString();

        mLoginPresenter.performLogin(userName, pwd);
    }

    @Override
    public void loginValidations() {
        Log.i(LOG_TAG, "TEST : loginValidations() is called...");

        Toast.makeText(this, "Please, Enter UserName and Password!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Log.i(LOG_TAG, "TEST : loginSuccess() is called...");

        Toast.makeText(getApplicationContext(), "Log In Success.", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(LoginActivity.this, CbActivity.class);
        startActivity(i);
    }

    @Override
    public void loginError() {
        Log.i(LOG_TAG, "TEST : loginError() is called...");

        Toast.makeText(this, "Log In Failure.", Toast.LENGTH_SHORT).show();
    }
}
