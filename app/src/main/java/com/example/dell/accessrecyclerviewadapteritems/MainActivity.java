package com.example.dell.accessrecyclerviewadapteritems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    DataAdapter adapter;
    ArrayList<String> Datalist = new ArrayList<>();
    Button btnSubmit;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        for (int i = 0; i < 20; i++)
            Datalist.add("Item " + i);
        set_rvLayoutManager();
        set_rvAdapter();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validation()) {
                    Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_LONG).show();

                } else
                    Toast.makeText(getApplicationContext(), "Fill all the Fields", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void set_rvLayoutManager() {
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setHasFixedSize(true);
    }

    public void set_rvAdapter() {
        adapter = new DataAdapter(MainActivity.this, Datalist);
        rv.setAdapter(adapter);
    }

    public boolean Validation() {
        boolean flag = true;
        int childcount = rv.getChildCount();
        for (int i = 0; i < childcount; i++) {
            if (rv.findViewHolderForLayoutPosition(i) instanceof DataAdapter.ViewHolder) {
                DataAdapter.ViewHolder viewHolder = (DataAdapter.ViewHolder) rv.findViewHolderForLayoutPosition(i);
                if (viewHolder.edtEmail.getText().length() == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


}
