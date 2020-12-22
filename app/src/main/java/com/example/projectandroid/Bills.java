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
import android.widget.Toast;

import java.util.ArrayList;

public class Bills extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner billSP,accountSP;
    EditText subsNumber, billAmount;
    Button pay;
    ListView LV;

    int size = MainActivity.object.size();
    String billNames []={"HYDRO","WATER","GAS","PHONE"}; // array to fill bill spinner
    String accountArray [] = new String[size];
    String subscriptionNumber;
    String type;
    String acount;
    public static ArrayList<DetClass> detList = new ArrayList<>(); // this will be used in DetailsAdapter class
    public static ArrayList<DetClass> detList1 = new ArrayList<>();
    public static ArrayList<DetClass> detList2 = new ArrayList<>();
    public static ArrayList<DetClass> detList3 = new ArrayList<>();
    public static ArrayList<DetClass> detList4 = new ArrayList<>();
    public static ArrayList<DetClass> detList5 = new ArrayList<>();

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
        if (MainActivity.object.get(0).getcNumber().equals("1111")) // if user with id 1111 log in show this on startup
        LV.setAdapter(new DetailsAdapter(detList,this)); // showing data in list view on startup of the screen

        if (MainActivity.object.get(0).getcNumber().equals("1112"))// if user with id 1112 log in show this on startup
            LV.setAdapter(new DetailsAdapter(detList1,this));

        if (MainActivity.object.get(0).getcNumber().equals("1113")) // if user with id 1111 log in show this on startup
            LV.setAdapter(new DetailsAdapter(detList2,this));

        if (MainActivity.object.get(0).getcNumber().equals("1114")) // if user with id 1111 log in show this on startup
            LV.setAdapter(new DetailsAdapter(detList3,this));

        if (MainActivity.object.get(0).getcNumber().equals("1115")) // if user with id 1111 log in show this on startup
            LV.setAdapter(new DetailsAdapter(detList4,this));

        if (MainActivity.object.get(0).getcNumber().equals("1116")) // if user with id 1111 log in show this on startup
            LV.setAdapter(new DetailsAdapter(detList5,this));

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

        if (subsNumber.getText().toString().isEmpty() || billAmount.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Fill the Details", Toast.LENGTH_SHORT).show();
        }
        else if (MainActivity.object.get(0).getcNumber().equals("1111")){  // if user with id 1111 log in use this arraylist(detList) of bill details

            double available = MainActivity.object.get(index).getAmount();
            double amount = Double.parseDouble(billAmount.getText().toString());
            for (int i = 0; i < 1; i++) {    // here using 1 because we want to substract money only one time
                if (available >= amount) {
                    available -= amount;
                    MainActivity.object.get(index).setAmount(available);
                    //detList.clear();
                    DetClass object = new DetClass(subsNumber.getText().toString(), type, billAmount.getText().toString(), acount); // creating object of DetClass
                    detList.add(object);   // adding that object in detList
                    LV.setAdapter(new DetailsAdapter(detList, this));   // sending that Array list of Det to Details Adapter to show number of rows and data
                    alertClass("Message", "Bill Paid Successfully", "Thank you");

                } else {
                    alertClass("Error", "Low Balance !!!!!", "Ok");
                }
            }
        }
        else if (MainActivity.object.get(0).getcNumber().equals("1112")){  // if user with id 1112 log in use this array list (detList1)of bill details
            double available = MainActivity.object.get(index).getAmount();
            double amount = Double.parseDouble(billAmount.getText().toString());
            for (int i = 0; i < 1; i++) {    // here using 1 because we want to substract money only one time
                if (available >= amount) {
                    available -= amount;
                    MainActivity.object.get(index).setAmount(available);
                    //detList.clear();
                    DetClass object = new DetClass(subsNumber.getText().toString(), type, billAmount.getText().toString(), acount); // creating object of DetClass
                    detList1.add(object);   // adding that object in detList
                    LV.setAdapter(new DetailsAdapter(detList1, this));   // sending that Array list of Det to Details Adapter to show number of rows and data
                    alertClass("Message", "Bill Paid Successfully", "Thank you");

                } else {
                    alertClass("Error", "Low Balance !!!!!", "Ok");
                }
            }
        }
        else if (MainActivity.object.get(0).getcNumber().equals("1113")){  // if user with id 1112 log in use this array list (detList1)of bill details
            double available = MainActivity.object.get(index).getAmount();
            double amount = Double.parseDouble(billAmount.getText().toString());
            for (int i = 0; i < 1; i++) {    // here using 1 because we want to substract money only one time
                if (available >= amount) {
                    available -= amount;
                    MainActivity.object.get(index).setAmount(available);
                    //detList.clear();
                    DetClass object = new DetClass(subsNumber.getText().toString(), type, billAmount.getText().toString(), acount); // creating object of DetClass
                    detList2.add(object);   // adding that object in detList
                    LV.setAdapter(new DetailsAdapter(detList2, this));   // sending that Array list of Det to Details Adapter to show number of rows and data
                    alertClass("Message", "Bill Paid Successfully", "Thank you");

                } else {
                    alertClass("Error", "Low Balance !!!!!", "Ok");
                }
            }
        }
        else if (MainActivity.object.get(0).getcNumber().equals("1114")){  // if user with id 1112 log in use this array list (detList1)of bill details
            double available = MainActivity.object.get(index).getAmount();
            double amount = Double.parseDouble(billAmount.getText().toString());
            for (int i = 0; i < 1; i++) {    // here using 1 because we want to substract money only one time
                if (available >= amount) {
                    available -= amount;
                    MainActivity.object.get(index).setAmount(available);
                    //detList.clear();
                    DetClass object = new DetClass(subsNumber.getText().toString(), type, billAmount.getText().toString(), acount); // creating object of DetClass
                    detList3.add(object);   // adding that object in detList
                    LV.setAdapter(new DetailsAdapter(detList3, this));   // sending that Array list of Det to Details Adapter to show number of rows and data
                    alertClass("Message", "Bill Paid Successfully", "Thank you");

                } else {
                    alertClass("Error", "Low Balance !!!!!", "Ok");
                }
            }
        }
        else if (MainActivity.object.get(0).getcNumber().equals("1115")){  // if user with id 1112 log in use this array list (detList1)of bill details
            double available = MainActivity.object.get(index).getAmount();
            double amount = Double.parseDouble(billAmount.getText().toString());
            for (int i = 0; i < 1; i++) {    // here using 1 because we want to substract money only one time
                if (available >= amount) {
                    available -= amount;
                    MainActivity.object.get(index).setAmount(available);
                    //detList.clear();
                    DetClass object = new DetClass(subsNumber.getText().toString(), type, billAmount.getText().toString(), acount); // creating object of DetClass
                    detList4.add(object);   // adding that object in detList
                    LV.setAdapter(new DetailsAdapter(detList4, this));   // sending that Array list of Det to Details Adapter to show number of rows and data
                    alertClass("Message", "Bill Paid Successfully", "Thank you");

                } else {
                    alertClass("Error", "Low Balance !!!!!", "Ok");
                }
            }
        }
        else if (MainActivity.object.get(0).getcNumber().equals("1116")){  // if user with id 1112 log in use this array list (detList1)of bill details
            double available = MainActivity.object.get(index).getAmount();
            double amount = Double.parseDouble(billAmount.getText().toString());
            for (int i = 0; i < 1; i++) {    // here using 1 because we want to substract money only one time
                if (available >= amount) {
                    available -= amount;
                    MainActivity.object.get(index).setAmount(available);
                    //detList.clear();
                    DetClass object = new DetClass(subsNumber.getText().toString(), type, billAmount.getText().toString(), acount); // creating object of DetClass
                    detList5.add(object);   // adding that object in detList
                    LV.setAdapter(new DetailsAdapter(detList5, this));   // sending that Array list of Det to Details Adapter to show number of rows and data
                    alertClass("Message", "Bill Paid Successfully", "Thank you");

                } else {
                    alertClass("Error", "Low Balance !!!!!", "Ok");
                }
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == R.id.billSP){
            type = billNames[position]; // gettting type of selected item in spinner

        }
        if ( parent.getId() == R.id.accountSP){

            index = position; //getting position of the selected item to use in arrays
            acount = String.valueOf(MainActivity.object.get(position).getAccountNumber()); // getting account number
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}