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
    boolean bool = false;

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

        if (accountNumber.getText().toString().isEmpty() || amount.getText().toString().isEmpty()){  // checking if the fields are empty
            Toast.makeText(this, "Please Fill the details", Toast.LENGTH_SHORT).show();
        }else {
            int number = 0;
            double money = 0;

                number = Integer.parseInt(accountNumber.getText().toString());
                money = Double.parseDouble(amount.getText().toString());

                for (int i = 0; i < MainActivity.object.size(); i++) {
                if (number == MainActivity.object.get(i).getAccountNumber() && money > 0) { // making sure that user has filled some amount
                    double availableBalance = MainActivity.object.get(i).getAmount();
                    availableBalance = MainActivity.object.get(i).getAmount() + money;
                    MainActivity.object.get(i).setAmount(availableBalance);
                    bool = false;
//                    details.setText("Amount Added");
                    break;

                } else {
                    bool = true;
                }
            }
        }
        if (bool == true){
            alertClass("Error","No Account Found","OK");
        }else
        {
            alertClass("Message","Amount Added Successfully","Thank You");
        }
    }

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

}