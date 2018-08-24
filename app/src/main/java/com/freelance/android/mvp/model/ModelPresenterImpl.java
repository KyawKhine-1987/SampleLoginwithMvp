package com.freelance.android.mvp.model;

import android.text.TextUtils;
import android.util.Log;

import com.freelance.android.mvp.presenter.LoginPresenter;
import com.freelance.android.mvp.view.ChkComponentView;
import com.freelance.android.mvp.view.LoginView;

public class ModelPresenterImpl implements LoginPresenter {

    private static final String LOG_TAG = ModelPresenterImpl.class.getName();

    LoginView mLoginView;
    ChkComponentView mChkComponentView;

    public ModelPresenterImpl(LoginView loginView) {
        Log.i(LOG_TAG, "TEST : ModelPresenterImpl() constructor  is called for LoginView...");

        this.mLoginView = loginView;
    }

    public ModelPresenterImpl(ChkComponentView mChkComponentView) {
        Log.i(LOG_TAG, "TEST : ModelPresenterImpl() constructor is called for ChkComponentView...");

        this.mChkComponentView = mChkComponentView;
    }

    @Override
    public void performLogin(String userName, String password) {
        Log.i(LOG_TAG, "TEST : performLogin() is called...");

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            mLoginView.loginValidations();
        } else {
            if (userName.equals("KK") && password.equals("12345")) {
                mLoginView.loginSuccess();
            } else {
                mLoginView.loginError();
            }
        }
    }

    public void checkBoxTasks(){
        Log.i(LOG_TAG, "TEST : checkBoxTasks() is called...");

        mChkComponentView.addListenerOnButton();
        mChkComponentView.addListenerOnCheckbox();
    }
}
