package com.example.simonmcneil.assignment2_simon_mcneil;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Create a global variable to display the province that is selected in the second activity by the user
    TextView provinceSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates an intent to get activity2 intent information
        Intent intent = getIntent();

        //gets the province name of activity 2
        String provinceName = intent.getStringExtra("provinceName");

        //Displays the province name. Initially this is blank at the beginning as nothing is selected
        provinceSelected = (TextView) findViewById(R.id.provinceDisplay);
        provinceSelected.setText(provinceName);

    }

    /**The following method is launched when going to the second activity
     * It involves creating a dialog view with two options. The positive button goes to the
     * second activity and the negative button stays in the current activity the user is in
     */
    public void onSelectProvinceClick(View view) {

        //important that this goes here and not as a global variable before the onCreate method
        //or else program will crash
        final Intent intent = new Intent(this,ProvinceSelectActivity.class);

        //Initialize AlertDialog

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_Holo_Dialog_Alert);
        //Doesn't allow the dialog box to close if user hits the back button.
        builder.setCancelable(false);
        builder.setMessage(R.string.dialog_Message)
                .setPositiveButton(R.string.dialog_positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.dialog_negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

        //Creates the dialog
        AlertDialog dialog = builder.create();
        //Shows the dialog
        dialog.show();
    }
}
