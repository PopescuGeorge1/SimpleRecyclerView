package com.example.simplerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*
TODO THIRD: create adapter
        -> MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
        -> implement methods
        -> create ViewHolder extends RecyclerView.ViewHolder class + constructor
TODO FOURTH: follow steps
*/

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //TODO 4.3: create and initialize a list of your items and a context
    // + getItemCount return list.size()
    private List<listItem> listOfItems;
    private Context context;

    public MyAdapter(List<listItem> listItems, Context context) {
        this.listOfItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO 4.1: create View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        //TODO 4.4: attach textViews to the holder
        // then back to MainActivity
        listItem listItem = listOfItems.get(position);
        holder.textViewHead.setText(listItem.getTitle());
        holder.textViewDesc.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //TODO 4.2 create TextViews and link them to their layout views
        public TextView textViewHead;
        public TextView textViewDesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHead = (TextView) itemView.findViewById(R.id.text_head);
            textViewDesc = (TextView) itemView.findViewById(R.id.text_description);

        }
    }
}
