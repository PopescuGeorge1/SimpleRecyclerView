package com.example.simplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*TODO
        =>implement RecyclerView
        =>choose data item: in this case is CARDVIEW
        !None of them are available from default => you will need to add the dependencies
    */
    /*
    TODO FIRST:add dependencies
     File->Project Structure -> Dependencies -> + -> Library Dependency -> recyclerview -> ok
                                                                       -> cardview -> ok
     (You can find the dependencies in Gradle Scripts -> build.gradle (Module ...) )
    */
    /*TODO SECOND.1: create layouts
        -> activity_main contains the recyclerview
        -> list_item contains the items to be displayed
           SECOND.2: create model
        -> listItem class: constructor + getters
    */
    /*
    TODO THIRD+FOURTH: MyAdapter
    */
    /*TODO FIFTH: create and initialize RecyclerView and its adapter
    */
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<listItem> myListOfItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myListOfItems = new ArrayList<>();
        //just adding some text
        for(int i=0;i<10;i++){
            listItem listItem = new listItem(
                    "Heading text "+i,
                    "Description"
            );
            //TODO: !!!Don't forget this
            myListOfItems.add(listItem);
        }
        //TODO: final
        adapter = new MyAdapter(myListOfItems,this);
        recyclerView.setAdapter(adapter);

    }
}