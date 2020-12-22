package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<CustomerDetails> details = new ArrayList<>();

    String cNumber[] = {"1111", "1112", "1113", "1114"};
    //String  password[] = {1111, 1112, 1113, 1114};

    public static ArrayList<CustomerDetails> object = new ArrayList<>() ;

    EditText c_number, pin;
    Button login;
    boolean bool = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        c_number = findViewById(R.id.cno);
        pin = findViewById(R.id.cpin);
        login = findViewById(R.id.loginbtn);
        login.setOnClickListener(this);


    }

    public void fillData() {
        details.add(new CustomerDetails(cNumber[0], cNumber[0], 10001,"Amarvir Singh", "Salary Account", "VPO Sohana, Mohali", "97845124577", 1000));
        details.add(new CustomerDetails(cNumber[0], cNumber[0], 10002,"Amarvir Singh", "Current Account", "VPO Sohana, Mohali", "9784512658", 2000));
        details.add(new CustomerDetails(cNumber[0], cNumber[0], 10003,"Amarvir Singh", "Savings Account", "VPO Sohana, Mohali", "9784512658", 3000));
        details.add(new CustomerDetails(cNumber[0], cNumber[0], 10004, "Amarvir Singh", "Fresh Account", "VPO Sohana, Mohali", "9784512658", 100));

        details.add(new CustomerDetails(cNumber[1], cNumber[1], 20001, "Ranjeet Singh", "Current Account", "VPO Sohana, Mohali", "978451258", 1500));
        details.add(new CustomerDetails(cNumber[1], cNumber[1], 20002, "Ranjeet Singh", "Salary Account", "VPO Sohana, Mohali", "978451258", 1800));
        details.add(new CustomerDetails(cNumber[1], cNumber[1], 20003, "Ranjeet Singh", "Savings Account", "VPO Sohana, Mohali", "978451258", 2500));

    }


    @Override
    public void onClick(View v) {

        String tempNum = c_number.getText().toString();
        String tempPass = pin.getText().toString();



        if (c_number.getText().toString().isEmpty() || pin.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), " Please Enter Both C_number and Pin", Toast.LENGTH_LONG).show();
        }

        for (int i = 0; i < details.size(); i++) {
            if (tempNum.equals(details.get(i).getcNumber()) && tempPass.equals(details.get(i).getPassword())) {
                for (int j = 0; j < details.size(); j++) {
                    if (details.get(i).getcNumber().equals(details.get(j).getcNumber())) {
                        // add password check
                        object.add(details.get(j));

                    }
                }
                Intent intent = new Intent(this,Menu.class);
                startActivity(intent);
                break;
            }
        }


        for (int i = 0; i < details.size(); i++) {
            if ( !tempNum.equals(details.get(i).getcNumber()) ||  !tempPass.equals(details.get(i).getPassword())) {

                Toast.makeText(getApplicationContext(), " Pin or cNumber is wrong", Toast.LENGTH_LONG).show();
               break;
            }
        }
    }
}