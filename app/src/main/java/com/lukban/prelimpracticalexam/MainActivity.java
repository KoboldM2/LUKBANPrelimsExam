package com.lukban.prelimpracticalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox act1, act2, act3, act4, act5, act6, act7, act8;
    EditText comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act1 =findViewById(R.id.checkBox);
        act2 =findViewById(R.id.checkBox2);
        act3 =findViewById(R.id.checkBox3);
        act4 =findViewById(R.id.checkBox4);
        act5 =findViewById(R.id.checkBox5);
        act6 =findViewById(R.id.checkBox6);
        act7 =findViewById(R.id.checkBox7);
        act8 =findViewById(R.id.checkBox8);

        comments = findViewById(R.id.editText2);
    }

    public void saveData(View v) {
        String act1Input = act1.getText().toString();
        String act2Input = act2.getText().toString();
        String act3Input = act3.getText().toString();
        String act4Input = act4.getText().toString();
        String act5Input = act5.getText().toString();
        String act6Input = act6.getText().toString();
        String act7Input = act7.getText().toString();
        String act8Input = act8.getText().toString();
        String commentsInput = comments.getText().toString();
        String nextLine = " ";
        FileOutputStream writer = null;
        FileOutputStream writerComments = null;

        try {
            writer = openFileOutput("activityList.txt",MODE_PRIVATE);
            writerComments = openFileOutput("comments.txt",MODE_PRIVATE);

            writer.write(act1Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act2Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act3Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act4Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act5Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act6Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act7Input.getBytes());
            writer.write(nextLine.getBytes());

            writer.write(act8Input.getBytes());

            writerComments.write(commentsInput.getBytes());
        }

        catch(FileNotFoundException e) {
            Log.d("error", "file not found");
        }
        catch(IOException e) {
            Log.d("error","IO not found");
        }

        finally {
            try {
                writer.close();
            }
            catch(IOException e) {
                Log.d("error","file not found");
            }
        }
        Toast.makeText(this, "data saved", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
