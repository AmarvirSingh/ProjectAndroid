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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TransferFunds extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //EditText sender,receiver,transferMoney;
    RadioButton rb1, rb2;
    TextView name, contact;

    Spinner sender;
    Button transfer;
    EditText transferMoney,etContact, etName,receiver;

    int senderacc,  receiveracc;
    int indexsend, indexrec;
    boolean bool = false;
    boolean showmessage = false;

    private static String enteredName = "";
    private static String enteredContact = "";
    private static double plus = 0;
    private static double minus = 0;

    int size = MainActivity.object.size();
     String numberArray[] = new String[size];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_funds);


    sender = findViewById(R.id.senderSP);
    receiver = findViewById(R.id.receiver);
    transferMoney = findViewById(R.id.transferMoney);
    transfer = findViewById(R.id.transfer);
    rb1 = findViewById(R.id.rb1);
    rb2 = findViewById(R.id.rb2);
    name = findViewById(R.id.name);
    etName = findViewById(R.id.etName);
    contact = findViewById(R.id.contact);
    etContact = findViewById(R.id.etContact);


    fillData();
    setRB1invisible();

    ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,numberArray);
    //using same data for the both spinners

    sender.setAdapter(aa);

    sender.setOnItemSelectedListener(this);



    transfer.setOnClickListener(this);

    rb1.setOnClickListener(this);
    rb2.setOnClickListener(this);
    }

    // filling the account numbers
    public void fillData(){
        for (int i =0; i< MainActivity.object.size(); i++){
            numberArray[i] = String.valueOf(MainActivity.object.get(i).getAccountNumber());
        }
    }

    public void sendMail(){

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

    //s etting views insivisible on radiobutton one
    public void setRB1invisible(){
    name.setVisibility(View.INVISIBLE);
    etContact.setVisibility(View.INVISIBLE);
    etName.setVisibility(View.INVISIBLE);
    contact.setVisibility(View.INVISIBLE);
    }

    // setting vie3ws visible on rb2 click
    public void setRB2Visible(){

        name.setVisibility(View.VISIBLE);
        etContact.setVisibility(View.VISIBLE);
        etName.setVisibility(View.VISIBLE);
        contact.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rb1) {
                setRB1invisible();
            showmessage = false; // setting this to false because we dont want to show message every time we change radio buttons
        }

        if (v.getId() == R.id.rb2){
            setRB2Visible();
            showmessage = false;
        }
        double transferAmount = 0;

        if (v.getId() == R.id.transfer){
                if (rb1.isChecked()){
                    transferAmount = Double.parseDouble(transferMoney.getText().toString());
                    receiveracc = Integer.parseInt(receiver.getText().toString());


                }else if (rb2.isChecked()){

                    transferAmount = Double.parseDouble(transferMoney.getText().toString());
                    enteredName = etName.getText().toString();
                    enteredContact = etContact.getText().toString();
                    receiveracc = Integer.parseInt(receiver.getText().toString());
                }

            double available = MainActivity.object.get(indexsend).getAmount();// extracting available balance in sender account using index of spinner
            double recAvailable = getReceiveracc(receiveracc);
            if (recAvailable != -1) {
                for (int i = 0; i < size; i++) {
                    if (transferAmount <= available) { //
                        minus = available - transferAmount;
                        plus = recAvailable + transferAmount;
                        MainActivity.object.get(indexsend).setAmount(minus);// setting amount to remaining balance
                         setAmountinReceiverAccount(receiveracc,plus);   // setting amount to updated balance

                        // some boolean value used for showing alert dialog boxes

                        bool = true;
                        showmessage = true;
                        break;

                    } else {
                        bool = false;
                        showmessage = true;

                    }
                }
            }
            else{
                Toast.makeText(this, "Please check the account Number", Toast.LENGTH_SHORT).show();
            }
        }

        // SHOWING MESSAGES
        if (bool == true && showmessage == true){
            alertClass("Message", "Transaction Complete \n available balance in Sender account " + minus + " \n available balance in receiver account = " + plus, "Thank you");
        }
        else if (bool == false && showmessage == true){
            alertClass("Error", "Balance is low", "OK :(");
        }

    }

    // this function take two arguments one is receivers account number and second ius the updated balance of that account number
    public void setAmountinReceiverAccount(int check,double money){
        for (int i =0; i < MainActivity.details.size(); i++){
            if (MainActivity.details.get(i).getAccountNumber() == check){
                 MainActivity.details.get(i).setAmount(money);
            }
        }

    }


    // this function return Account balance if account number is present  else -1
    public double getReceiveracc(int check){
        for (int i =0; i < MainActivity.details.size(); i++){
            if (MainActivity.details.get(i).getAccountNumber() == check){
                return MainActivity.details.get(i).getAmount();
            }

        }
        return -1;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    if (parent.getId() == R.id.senderSP){
    senderacc = Integer.parseInt(numberArray[position]);  // converting string to integer value and getting value of sender account number
        indexsend = position;
    }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}