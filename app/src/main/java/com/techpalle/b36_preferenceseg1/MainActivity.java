package com.techpalle.b36_preferenceseg1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TASK 1 : LOAD SIGNUP FRAGMENT INTO FRAMELAYOUT - CONTAINER
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SignUpFragment signUpFragment = new SignUpFragment();
        transaction.add(R.id.container, signUpFragment);
        transaction.commit();
        //END OF TASK 1
    }
    public void credentialsSaved(){
        //HERE MAIN ACTIVITY WILL REPLACE SIGNUP FRAGMENT WITH LOGIN FRAGMENT
        //TASK 3 - START
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        transaction.replace(R.id.container, loginFragment);
        transaction.commit();
        //END
    }
}
