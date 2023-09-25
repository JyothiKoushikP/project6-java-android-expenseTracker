package com.example.expensevoiceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BeginScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin);
    }

    //Speech Input Code (Take Speech Input using Google Voice Assistant)
    public void getSpeechInput(View view){
        Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        //start Intent Activity for speed with requestCode 10 (Any number would suffice)
        // Before starting activity Intent (Check if the device supports speech input)
        if(speechIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(speechIntent,10);
        } else {
            Toast.makeText(this, "Oops!! Looks like your device doesn't support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10){
            if(resultCode == RESULT_OK && data != null){
                ArrayList<String> userInput = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                if (userInput.get(0).equals("launch")){
                    Intent navigateToLoginIntent = new Intent(BeginScreen.this,LoginScreen.class);
                    startActivity(navigateToLoginIntent);
                }
            }
        }
    }
}
