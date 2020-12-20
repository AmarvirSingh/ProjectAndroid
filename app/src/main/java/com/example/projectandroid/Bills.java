package com.example.projectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class Bills extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner billSP,accountSP;
    EditText subsNumber, billAmount;
    Button pay;
    ListView LV;

    int size = MainActivity.object.size();
    String billNames []={"HYDRO","WATER","GAS","PHONE"};
    String accountArray [] = new String[size];
    String account;
    String type;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        fillData();

        billAmount = findViewById(R.id.billAmount);
        billSP = findViewById(R.id.billSP);
        accountSP = findViewById(R.id.accountSP);
        subsNumber = findViewById(R.id.subsNumber);

        pay = findViewById(R.id.pay);
        LV = findViewById(R.id.LV);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,billNames);
        billSP.setAdapter(aa);
        billSP.setOnItemSelectedListener(this);
        ArrayAdapter bb = new ArrayAdapter( this, android.R.layout.simple_spinner_dropdown_item,accountArray);
        accountSP.setAdapter(bb);
        accountSP.setOnItemSelectedListener(this);
        pay.setOnClickListener(this);


    }


    // filling the account numbers
    public void fillData(){
        for (int i =0; i< MainActivity.object.size(); i++){
            accountArray[i] = String.valueOf(MainActivity.object.get(i).getAccountNumber());
        }
    }


    // class for dialog box
    public void alertClass(String title,String message , String button){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    @Override
    public void onClick(View v) {
        double available = MainActivity.object.get(index).getAmount();
        double amount = Double.parseDouble(billAmount.getText().toString());
        for (int i =0;i<MainActivity.object.size();i++){
           if (available >= amount){

               // alert calss minus the amount show in list view;


           }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == R.id.billSP){
            type = billNames[position];

        }
        if ( parent.getId() == R.id.accountSP){
            account = accountArray[position];
            index = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}