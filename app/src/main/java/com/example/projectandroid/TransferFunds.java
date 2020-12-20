package com.example.projectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TransferFunds extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //EditText sender,receiver,transferMoney;
    Spinner sender, receiver;
    Button transfer;
    EditText transferMoney;

    int senderacc,  receiveracc;
    int indexsend, indexrec;

    int size = MainActivity.object.size();
     String numberArray[] = new String[size];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_funds);
    sender = findViewById(R.id.senderSP);
    receiver = findViewById(R.id.receiverSP);
    transferMoney = findViewById(R.id.transferMoney);
    transfer = findViewById(R.id.transfer);
    fillData();

    ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,numberArray);
    sender.setAdapter(aa);
    receiver.setAdapter(aa);
    sender.setOnItemSelectedListener(this);
    receiver.setOnItemSelectedListener(this);


    transfer.setOnClickListener(this);

    }

    // filling the account numbers
    public void fillData(){
        for (int i =0; i< MainActivity.object.size(); i++){
            numberArray[i] = String.valueOf(MainActivity.object.get(i).getAccountNumber());
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
        alert.show();            }



    @Override
    public void onClick(View v) {
        if (senderacc == receiveracc){
            Toast.makeText(this,"Cannot transfer money to same account",Toast.LENGTH_LONG).show();
        }
        else {
            double transferAmount = Double.parseDouble(transferMoney.getText().toString());
            double available = MainActivity.object.get(indexsend).getAmount(); // available balance in sender account
            double recAvailable = MainActivity.object.get(indexrec).getAmount(); // available balance in receiver account

            for (int i = 0; i < size; i++) {
                if (transferAmount <= available) { //
                    double minus = available - transferAmount;
                    double plus = recAvailable + transferAmount;
                    MainActivity.object.get(indexsend).setAmount(minus);
                    MainActivity.object.get(indexrec).setAmount(plus);
                    alertClass("Message", "Transaction Complete \n available balance in Sender account " + minus + " \n available balance in receiver account = " + plus, "Thank you");
                } else {
                    alertClass("Error", "Balance is low", "OK :(");
                }
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    if (parent.getId() == R.id.senderSP){
    senderacc = Integer.parseInt(numberArray[position]);  // converting string to integer value and getting value of sender account number
        indexsend = position;
    }
    if (parent.getId() == R.id.receiverSP){

    receiveracc = Integer.parseInt(numberArray[position]);// getting value of receiver account
    indexrec = position;
    }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}