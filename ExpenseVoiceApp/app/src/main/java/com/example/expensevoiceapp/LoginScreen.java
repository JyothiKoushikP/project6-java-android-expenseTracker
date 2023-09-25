package com.example.expensevoiceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class LoginScreen extends Activity {

    private AlertDialog.Builder dbBuilder;
    private AlertDialog dialog;
    ImageView hintIcon;
    ImageView signInButton;
    Button okButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        hintIcon =findViewById(R.id.im1);
        signInButton = findViewById(R.id.im2);
    }

    public void initiateDialogPopUp(View view) {
        openHintPopUpWindow();
    }

    public void openHintPopUpWindow() {
        dbBuilder = new AlertDialog.Builder(this);
        final View popUpView = getLayoutInflater().inflate(R.layout.popup,null);
        okButton = (Button) popUpView.findViewById(R.id.OKbutton);

        dbBuilder.setView(popUpView);
        dialog = dbBuilder.create();
        dialog.show();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
