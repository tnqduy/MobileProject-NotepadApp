package com.example.akduy.demonotepadapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    FloatingActionButton btnAddnote;
    NoteItem sampleItem, sampleItem1;
    RecyclerView myRecyclerView;
    CustomIconLabelAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<NoteItem> listNote;

    public static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleItem = new NoteItem("Sample title", "Sample content");
        sampleItem1 = new NoteItem("Sample title1", "Sample content1");
        listNote = new ArrayList<>();
        listNote.add(sampleItem);
        listNote.add(sampleItem1);

        myRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        myRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        adapter = new CustomIconLabelAdapter(this, listNote);
        myRecyclerView.setAdapter(adapter);

        //to add new note
        btnAddnote = (FloatingActionButton) findViewById(R.id.fab);
        btnAddnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"This action will add a new note", Toast.LENGTH_LONG).show();
                Intent mIntent = new Intent(MainActivity.this, AddNewNoteActivity.class);
                MainActivity.this.startActivityForResult(mIntent, MY_REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE ) {

            String newNoteTitle = data.getStringExtra("newTitle");
            String newNoteContent = data.getStringExtra("newContent");
            NoteItem newNote = new NoteItem(newNoteTitle,newNoteContent);
            listNote.add(newNote);
            adapter.notifyDataSetChanged();

        } else {

        }
    }
    //what will occur when user click a note
    public static void onRecyclerItemClick(int adapterPosition) {

    }
}
