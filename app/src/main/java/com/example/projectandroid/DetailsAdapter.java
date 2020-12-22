package com.example.projectandroid;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsAdapter extends BaseAdapter {

    private ArrayList<DetClass> det;
    LayoutInflater inflater;

    public DetailsAdapter(ArrayList<DetClass> det, Context context) {
        this.det = det;
        inflater = inflater.from(context);
    }

    @Override
    public int getCount() {
        return det.size();
    }

    @Override
    public Object getItem(int position) {
        return det.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null){
            convertView = inflater.inflate(R.layout.details_adapter, null);
            holder.subscriptionNumber = convertView.findViewById(R.id.adapterSubnumber);
            holder.billType = convertView.findViewById(R.id.adapterBillType);
            holder.amount = convertView.findViewById(R.id.adapterBillAmount);
            holder.accountNumber = convertView.findViewById(R.id.adapterAccountNumber);
            convertView.setTag(holder);

        }else{
            convertView.getId();

        }
        holder.subscriptionNumber.setText(Bills.detList.get(position).getNumber());
        holder.billType.setText(Bills.detList.get(position).getDetType());
        holder.amount.setText(Bills.detList.get(position).getAmount());
        holder.accountNumber.setText(Bills.detList.get(position).getAccount());

        return convertView;
    }
    static class ViewHolder{
        TextView subscriptionNumber,billType,amount, accountNumber;

    }
}
