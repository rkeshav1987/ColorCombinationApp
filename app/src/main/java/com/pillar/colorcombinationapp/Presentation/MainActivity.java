package com.pillar.colorcombinationapp.Presentation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.pillar.colorcombinationapp.R;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText editText;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this,new ServiceClass(MainActivity.this));

        launchNoOfFamilyMembersDialog();
    }
    private void launchNoOfFamilyMembersDialog() {

        LayoutInflater li = MainActivity.this.getLayoutInflater();

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(li.inflate(R.layout.prompt, null));
        builder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Dialog f = (Dialog) dialog;
                                editText = (EditText) f.findViewById(R.id.inputFamilyMembers);
                                onEnteringValueForNoOfMembers();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                Log.d("cancel", "cancel");
                            }
                        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void onEnteringValueForNoOfMembers() {
        presenter.onEnteringValueForNoOfMembers();
    }
}
