package com.example.webview;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
public class NotesActivity extends AppCompatActivity {
    Button save,clear,undo;

    SharedPreferences sharedpreferences;

    public static final String myNote = "mypref";

    public static final String Note = "note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        final EditText enterText = findViewById(R.id.noteArea);
        save = findViewById(R.id.save);
        clear =findViewById(R.id.clear);
        undo = findViewById(R.id.undo);
        sharedpreferences = getSharedPreferences(myNote,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Note)) {
            enterText.setText(sharedpreferences.getString(Note, ""));
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enterText.getText().toString().isEmpty()) {
                    File file = new File(NotesActivity.this.getFilesDir(), "text");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    try {
                        File gpxfile = new File(file, "sample");
                        FileWriter writer = new FileWriter(gpxfile);
                        writer.append(enterText.getText().toString());
                        writer.flush();
                        writer.close();
                        Toast.makeText(NotesActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                    }
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText enterText = findViewById(R.id.noteArea);
                String e = enterText.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Note,e);
                editor.commit();

                enterText.setText("");
        }});

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText enterText = findViewById(R.id.noteArea);
                sharedpreferences = getSharedPreferences(myNote,
                        Context.MODE_PRIVATE);

                if (sharedpreferences.contains(Note)) {
                    enterText.setText(sharedpreferences.getString(Note, ""));
                }
            }
        });
    }
}
