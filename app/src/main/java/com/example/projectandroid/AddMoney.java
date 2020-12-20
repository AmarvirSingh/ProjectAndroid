package com.example.projectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMoney extends AppCompatActivity implements View.OnClickListener {

    Button add;
    EditText accountNumber, amount;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        add = findViewById(R.id.add);
        accountNumber = findViewById(R.id.accountNumberwith);
        amount = findViewById(R.id.amountwith);
        details = findViewById(R.id.details);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (accountNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Account Number ", Toast.LENGTH_LONG).show();
        } else if (amount.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Amount ", Toast.LENGTH_LONG).show();
        } else if (accountNumber.getText().toString().isEmpty() && amount.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Account Number and Amount", Toast.LENGTH_LONG).show();
        }

        int number = 0;
        double money = 0 ;
        if (!accountNumber.getText().toString().isEmpty() && !amount.getText().toString().isEmpty()) {
            number = Integer.parseInt(accountNumber.getText().toString());
            money = Double.parseDouble(amount.getText().toString());
        }
        for (int i = 0; i < MainActivity.object.size(); i++) {
            if (number == MainActivity.object.get(i).getAccountNumber() && money > 0) { // making sure that user has filled some amount
                double availableBalance = MainActivity.object.get(i).getAmount();
                availableBalance = MainActivity.object.get(i).getAmount() + money;
                MainActivity.object.get(i).setAmount(availableBalance);

                details.setText("Amount Added");
                break;

            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this).setTitle("Error").setMessage("No account found").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();            }


        }
    }
}