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

public class WithdrawMoney extends AppCompatActivity implements View.OnClickListener {
    Button withdraw;
    EditText accountNumber, amount;
    TextView details;

    boolean bool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_money);

        withdraw = findViewById(R.id.withdraw);
        accountNumber = findViewById(R.id.accountNumberwith);
        amount = findViewById(R.id.amountwith);

        withdraw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (accountNumber.getText().toString().isEmpty() || amount.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
        }else {
            int number = 0;
            double withdrawmoney = 0;
            if (!accountNumber.getText().toString().isEmpty() && !amount.getText().toString().isEmpty()) {
                number = Integer.parseInt(accountNumber.getText().toString());
                withdrawmoney = Double.parseDouble(amount.getText().toString());

            }
            for (int i = 0; i < MainActivity.object.size(); i++) {
                if (number == MainActivity.object.get(i).getAccountNumber() && withdrawmoney <= MainActivity.object.get(i).getAmount()) { // checking amount
                    double balance = MainActivity.object.get(i).getAmount() - withdrawmoney;
                    MainActivity.object.get(i).setAmount(balance);
                    bool = false;
                    // details.setText("Amount Added");
                    alertClass("Done", "" + withdrawmoney + " Money WithDrawn \n Available balance = " + balance, "Thank you");
                    break;

                } else {
                    bool = true;
                }
            }
            if (bool == true) {
                alertClass("Eroor", "No Account Found", "OK");
            }
        }
    }

    // creating method for alert dialog box
    public void alertClass(String title,String message , String button){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();            }

}
