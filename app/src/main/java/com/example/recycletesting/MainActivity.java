package com.example.recycletesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list;
    MyAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("this is my first adapter");
        }
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyaViewHolder> {

    Context context;
    List<String> list;

    public MyAdapter(Context context, List<String> list) {

        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MyaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyaViewHolder holder, int position) {

        holder.name.getText().toString();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyaViewHolder extends RecyclerView.ViewHolder {

        EditText name,ph,mail;

        public MyaViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.name);
            ph =itemView.findViewById(R.id.pho);
            mail =itemView.findViewById(R.id.mail);

        }
    }


}
}
