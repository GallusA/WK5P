package com.example.gallusawa.wk5p.View.SettingsActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gallusawa.wk5p.Injection.settingsactivity.DaggerSettingsActivityComponent;
import com.example.gallusawa.wk5p.R;

import javax.inject.Inject;

public class SettingsActivity extends AppCompatActivity implements SettingsActivityContract.View {
    private static final String PREFS_NAME = "myPref";

    EditText etZip;
    Spinner spinner;
    Toolbar bar;
    @Inject
    SettingsActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        etZip = (EditText) findViewById(R.id.etZipCode) ;
        spinner = (Spinner) findViewById(R.id.spinner);
        bar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(bar);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        setupDagger();
        presenter.attachView(this);
        setToolbarBackPressed();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void setupDagger() {
        DaggerSettingsActivityComponent.create().inject(this);
    }

    private void setToolbarBackPressed() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Umbrella settings");
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",etZip.getText().toString()+","+ spinner.getSelectedItem().toString());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    @Override
    public void showError(String s) {

    }
}
