package com.example.akduy.demonotepadapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class AddNewNoteActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtnewTitle, txtnewContent;
    String newTitle, newContent;
    Button btnAddNewNote, btnSetReminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_note_layout);


        txtnewContent = (EditText) findViewById(R.id.txtNewContent);
        txtnewTitle = (EditText) findViewById(R.id.txtNewTitle);
        btnAddNewNote = (Button) findViewById(R.id.btnAddnote);
        btnAddNewNote.setOnClickListener(this);
        btnSetReminder = (Button) findViewById(R.id.btnSetReminder);

    }


    @Override
    public void onClick(View v) {
        newTitle = txtnewTitle.getText().toString();
        newContent = txtnewContent.getText().toString();

        if (v.getId() == btnAddNewNote.getId())
        {
            Intent data = new Intent();
            data.putExtra("newTitle",newTitle);
            data.putExtra("newContent",newContent);
            this.setResult(Activity.RESULT_OK, data);

            super.onBackPressed();
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent data = new Intent();
        data.putExtra("title",newTitle);
        data.putExtra("content",newContent);
        this.setResult(Activity.RESULT_CANCELED, data);

        super.onBackPressed();
    }
}
