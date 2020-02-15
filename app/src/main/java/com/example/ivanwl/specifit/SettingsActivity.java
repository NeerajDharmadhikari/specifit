package com.example.ivanwl.specifit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.ivanwl.specifit.Services.Firebase.Firebase;
import com.google.firebase.database.core.view.Change;

import java.util.HashMap;
import java.util.Map;
import static com.example.ivanwl.specifit.Utils.Utils.print;


public class SettingsActivity extends AppCompatActivity {
    private Firebase firebase;

    //  TODO - Change settings options
    //  XML Location of settings options are in
    //  /res/xml/root_preferences.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        firebase = new Firebase();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                super.onBackPressed();
                print("Back Button Clicked");
                firebase.saveSettings(mapSettings());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Map<String, Object> mapSettings() {
        Map<String, Object> map = new HashMap<>();
        map.put("KEY", "VALUE");
        return map;
    }
}