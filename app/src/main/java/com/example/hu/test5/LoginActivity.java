package com.example.hu.test5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView viewPassword;//密码是否可见切换按钮
    private EditText editPassword;//密码输入框
    private EditText editPhone;//手机号码输入框
    private Button buttonLogin;//登陆按钮
    private TextView retrievePassword;//密码找回按钮
    private TextView newRegister;//注册按钮
    private boolean seePassword = false;//密码输入是否可见
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //view初始化
        viewPassword = (ImageView) findViewById(R.id.view_password);
        editPassword = (EditText) findViewById(R.id.edit_password);
        buttonLogin = (Button) findViewById(R.id.buton_login);
        retrievePassword = (TextView) findViewById(R.id.retrieve_pw);
        newRegister = (TextView) findViewById(R.id.new_register);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        //设置所有按钮的监听
        viewPassword.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        retrievePassword.setOnClickListener(this);
        newRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.view_password:
                int pos = editPassword.getSelectionEnd();
                if (seePassword == false) {
                    viewPassword.setImageResource(R.drawable.view1b);
                    editPassword.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                    seePassword = true;
                } else {
                    viewPassword.setImageResource(R.drawable.view1a);
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    seePassword = false;
                }
                editPassword.setSelection(pos);
                break;
            case R.id.buton_login:
                break;
            case R.id.retrieve_pw:
                String number = editPhone.getText().toString();
                intent = new Intent(this, RetrievePasswordActivity.class);
                if (number.length() == 11) {
                    intent.putExtra("phone", number);
                }
                startActivity(intent);
                break;
            case R.id.new_register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
