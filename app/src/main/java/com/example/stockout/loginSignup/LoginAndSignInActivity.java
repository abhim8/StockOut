package com.example.stockout.loginSignup;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.stockout.R;

public class LoginAndSignInActivity extends AppCompatActivity {


    Button signInFragmentButton, signUpFragmentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signin);
        signInFragmentButton = findViewById(R.id.fsib);
        signUpFragmentButton = findViewById(R.id.fsub);
        replaceFragment(new SignInFragment());

        signInFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // changing button and text color
                Button b1 = (Button)signInFragmentButton;
                b1.setBackgroundColor(Color.parseColor("#ffffff"));
                b1.setTextColor(Color.parseColor("#000000"));
                Button b2 = (Button)signUpFragmentButton;
                b2.setBackgroundColor(Color.parseColor("#dee6ec"));
                b2.setTextColor(Color.parseColor("#5C5B5B"));


                replaceFragment(new SignInFragment());
            }
        });

        signUpFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // changing button and text color
                Button b1 = (Button)signInFragmentButton;
                b1.setBackgroundColor(Color.parseColor("#dee6ec"));
                b1.setTextColor(Color.parseColor("#5C5B5B"));
                Button b2 = (Button)signUpFragmentButton;
                b2.setBackgroundColor(Color.parseColor("#ffffff"));
                b2.setTextColor(Color.parseColor("#000000"));


                replaceFragment(new SignUpFragment());


            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.accl, fragment);
        fragmentTransaction.commit();
    }
}



















