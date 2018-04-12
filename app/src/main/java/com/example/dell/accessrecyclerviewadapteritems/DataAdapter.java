package com.example.dell.accessrecyclerviewadapteritems;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 4/12/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    ArrayList<String> datalist = new ArrayList<>();
    View view;

    public DataAdapter(Context context, ArrayList<String> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.dataadapter_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.tvname.setText(datalist.get(position));
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
  public EditText edtEmail;
        TextView tvname;

        public ViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvName);
            edtEmail = (EditText) itemView.findViewById(R.id.edtEmail);
        }
    }
}
