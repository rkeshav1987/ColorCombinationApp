package com.pillar.colorcombinationapp.Presentation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.EventListener;
import com.pillar.colorcombinationapp.R;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText editText;
    private MainPresenter presenter;

    private Spinner beginSpinner;
    private Spinner endSpinner;

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    private int mCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        presenter = new MainPresenter(this,new ServiceClass(MainActivity.this));

        launchNoOfFamilyMembersDialog();
    }

    private void initialize() {
        beginSpinner=(Spinner) findViewById(R.id.beginSpinner);
        endSpinner=(Spinner) findViewById(R.id.endSpinner);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);

        textView1=(TextView)findViewById(R.id.txtview1);
        textView2=(TextView)findViewById(R.id.txtview2);
        textView3=(TextView)findViewById(R.id.txtview3);
        textView4=(TextView)findViewById(R.id.txtview4);
        textView5=(TextView)findViewById(R.id.txtview5);
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

    private void showSnackBar(int resId) {
        SnackbarManager.show(
                com.nispok.snackbar.Snackbar.with(getApplicationContext())
                        .text(getString(resId))
                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                        .eventListener(new EventListener() {
                            @Override
                            public void onShow(com.nispok.snackbar.Snackbar snackbar) {

                            }

                            @Override
                            public void onShowByReplace(com.nispok.snackbar.Snackbar snackbar) {

                            }

                            @Override
                            public void onShown(com.nispok.snackbar.Snackbar snackbar) {

                            }

                            @Override
                            public void onDismiss(com.nispok.snackbar.Snackbar snackbar) {
                                launchNoOfFamilyMembersDialog();
                            }

                            @Override
                            public void onDismissByReplace(com.nispok.snackbar.Snackbar snackbar) {

                            }

                            @Override
                            public void onDismissed(com.nispok.snackbar.Snackbar snackbar) {
                            }
                        })
                , MainActivity.this);
    }

    private void onEnteringValueForNoOfMembers() {
        presenter.onEnteringValueForNoOfMembers();
    }

    @Override
    public String getNoOfMembersValue() {
        return editText.getText().toString();
    }

    @Override
    public void showNoOfMembersEmptyError(int resId) {
        showSnackBar(resId);
    }

    @Override
    public void showNoOfMembersOutofRangeError(int resId) {
        showSnackBar(resId);
    }

    @Override
    public void startProcessing(int count) {
        mCount=count;
        initializeSpinner(count);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.next:
                getColorCodes(mCount);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private void initializeSpinner(int count){

        beginSpinner.setVisibility(View.VISIBLE);
        endSpinner.setVisibility(View.VISIBLE);

        switch (count){
            case 1: spinner1.setVisibility(View.VISIBLE);

                textView1.setVisibility(View.VISIBLE);
                break;

            case 2: spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                break;

            case 3: spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);

                break;


            case 4: spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                break;

            case 5: spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                break;
        }

    }

    private void getColorCodes(int count) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(beginSpinner.getSelectedItem() + "," + endSpinner.getSelectedItem());

        switch (count){
            case 1: stringBuilder.append(" "+spinner1.getSelectedItem()).toString();
                break;

            case 2:stringBuilder.append(" "+spinner1.getSelectedItem()).toString();
                stringBuilder.append(" "+spinner2.getSelectedItem()).toString();
                break;

            case 3:stringBuilder.append(" "+spinner1.getSelectedItem()).toString();
                stringBuilder.append(" "+spinner2.getSelectedItem()).toString();
                stringBuilder.append(" " + spinner3.getSelectedItem().toString());
                break;

            case 4:stringBuilder.append(" "+spinner1.getSelectedItem()).toString();
                stringBuilder.append(" "+spinner2.getSelectedItem()).toString();
                stringBuilder.append(" " + spinner3.getSelectedItem().toString());
                stringBuilder.append(" "+spinner4.getSelectedItem().toString());
                break;

            case 5:stringBuilder.append(" "+spinner1.getSelectedItem()).toString();
                stringBuilder.append(" "+spinner2.getSelectedItem()).toString();
                stringBuilder.append(" " + spinner3.getSelectedItem().toString());
                stringBuilder.append(" "+spinner4.getSelectedItem().toString());
                stringBuilder.append(" " + spinner5.getSelectedItem().toString());
                break;
        }

        new ServiceClass(MainActivity.this).start(stringBuilder.toString());
    }
}
