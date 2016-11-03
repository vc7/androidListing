package com.vc7.listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class FormActivity extends AppCompatActivity {

    EditText headerEditText;
    EditText titleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        headerEditText = (EditText) findViewById(R.id.headerEditText);
        titleEditText = (EditText) findViewById(R.id.titleEditText);
    }

    public void submit(View view) {

        Intent intent = new Intent();
        intent.putExtra("title", titleEditText.getText().toString());
        intent.putExtra("header", headerEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
