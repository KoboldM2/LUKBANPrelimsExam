package com.lukban.prelimpracticalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;

public class SecondActivity extends AppCompatActivity {
    /*
        writer = openFileOutput("activityList.txt",MODE_PRIVATE);
        writerComments = openFileOutput("comments.txt",MODE_PRIVATE);
        textview 5 = enlisted activities
        textview 7 = comments
     */

    String activityFile = "activityList.txt";
    String commentsFile = "comments.txt";

    TextView activityList, comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.setTitle("Confirmation/Summary");
        activityList = findViewById(R.id.textView);
        comments = findViewById(R.id.textView2);


        FileInputStream fis = null;

        try {
            fis = openFileInput(activityFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\r\n");
            }

            activityList.setText(sb.toString());
        }
        catch(FileNotFoundException e) {
            Log.d("error","file not found");
        }
        catch(IOException e) {
            Log.d("error","IO Error");
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch(IOException e) {
                    Log.d("error","IO Error");
                }
            }
        }

        try {
            fis = openFileInput(commentsFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\r\n");
            }

            comments.setText(sb.toString());
        }
        catch(FileNotFoundException e) {
            Log.d("error","file not found");
        }
        catch(IOException e) {
            Log.d("error","IO Error");
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch(IOException e) {
                    Log.d("error","IO Error");
                }
            }
        }

    }





    public void previousPage(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void sendData(View v) {
        Toast.makeText(this, "Registration sent...", Toast.LENGTH_LONG).show();
    }
}
