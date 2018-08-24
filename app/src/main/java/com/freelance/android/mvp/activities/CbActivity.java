package com.freelance.android.mvp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.freelance.android.mvp.R;
import com.freelance.android.mvp.model.ModelPresenterImpl;
import com.freelance.android.mvp.presenter.LoginPresenter;
import com.freelance.android.mvp.view.ChkComponentView;

public class CbActivity extends AppCompatActivity implements ChkComponentView {

    private static final String LOG_TAG = CbActivity.class.getName();

    LoginPresenter mLoginPresenter;
    CheckBox chk1, chk2, chk3;
    Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST : onCreate() is called...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb);

        chk1 = this.findViewById(R.id.chk_dog);
        chk2 = this.findViewById(R.id.chk_cat);
        chk3 = this.findViewById(R.id.chk_cow);
        select = this.findViewById(R.id.btnSelect);
        mLoginPresenter = new ModelPresenterImpl( CbActivity.this);
        mLoginPresenter.checkBoxTasks();
    }

    @Override
    public void addListenerOnButton() {
        Log.i(LOG_TAG, "TEST : addListenerOnButton() is called...");

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "TEST : onClick() is called...");

                StringBuffer result = new StringBuffer();
                result.append("Dog : ").append(chk1.isChecked());
                result.append("\nCat : ").append(chk2.isChecked());
                result.append("\nCow : ").append(chk3.isChecked());

                Toast.makeText(CbActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void addListenerOnCheckbox() {
        Log.i(LOG_TAG, "TEST : addListenerOnCheckbox() is called...");

        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "TEST : onClick() is called...");

                if (((CheckBox)view).isChecked()) {

                    Toast.makeText(CbActivity.this, "Dog is selected.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
