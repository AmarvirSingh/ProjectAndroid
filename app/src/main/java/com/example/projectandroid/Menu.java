package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    TextView welcome;

    Button showBalance,addMoney,withdrawMoney,payBills,transferMoney,logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //  filling();


        showBalance=findViewById(R.id.sb);
        addMoney=findViewById(R.id.am);
        withdrawMoney=findViewById(R.id.wm);
        payBills=findViewById(R.id.pb);
        transferMoney=findViewById(R.id.tm);
        welcome = findViewById(R.id.textView3);
        logout = findViewById(R.id.logout);

        welcome.setText("Welcome " + MainActivity.object.get(0).getName());
        showBalance.setOnClickListener(this);
        addMoney.setOnClickListener(this);
        withdrawMoney.setOnClickListener(this);
        payBills.setOnClickListener(this);
        logout.setOnClickListener(this);
        transferMoney.setOnClickListener(this);
    }





    @Override
    public void onClick(View v) {
        if(v.getId()==(R.id.sb))
        {
            Intent intent = new Intent(this, ShowBalance.class);
            startActivity(intent);
        }else if (v.getId()==(R.id.am))
        {
            Intent intent = new Intent(this, AddMoney.class);
            startActivity(intent);
        }else if (v.getId()==(R.id.wm))
        {
            Intent intent= new Intent(this, WithdrawMoney.class);
            startActivity(intent);
        }else if(v.getId()==(R.id.pb))
        {
            Intent intent = new Intent(this, Bills.class);
            startActivity(intent);
        }else if(v.getId()==(R.id.tm)) {
            Intent intent = new Intent(this, TransferFunds.class);
            startActivity(intent);
        }else if (v.getId() == R.id.logout){
            MainActivity.object.clear();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}