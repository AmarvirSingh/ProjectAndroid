package com.example.projectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowBalance extends AppCompatActivity implements View.OnClickListener {

    EditText sbAccount;
    TextView details;
    Button sbButton;
    boolean bool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_balance);

        sbAccount = findViewById(R.id.sbaccount);
        sbButton = findViewById(R.id.sbbtn);

        details = findViewById(R.id.details);
        sbButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (sbAccount.getText().toString().isEmpty()){
            Toast.makeText(this,"Please Enter Account Number",Toast.LENGTH_LONG).show();
        }else {
            int number = Integer.parseInt(sbAccount.getText().toString());
            for (int i = 0; i < MainActivity.object.size(); i++) {
                if (number == MainActivity.object.get(i).getAccountNumber()) {
                    details.setText("Name = " + MainActivity.object.get(i).getName() + "\nBalance = "
                            + MainActivity.object.get(i).getAmount() + "\t("
                            + MainActivity.object.get(i).getType() + ")");
                    bool = false;
                    break;
                } else {
                    bool = true;
                   // details.setText("Account Not Found");

                }
            }

        }
        if (bool == true){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this).setTitle("Error").setMessage("No account found").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alert = alertDialogBuilder.create();
            alert.show();

        }
    }
}