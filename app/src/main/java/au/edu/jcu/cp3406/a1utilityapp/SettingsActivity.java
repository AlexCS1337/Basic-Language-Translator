package au.edu.jcu.cp3406.a1utilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    public static final int SETTINGS_REQUEST = 1;
    public String UILanguageSelected;
    public String targetLanguageSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("UILanguageSelected", UILanguageSelected);
        outState.putString("targetLanguageSelected", targetLanguageSelected);
    }

    public void backClicked(View view) {
        Intent intent = new Intent(this,
                MainActivity.class);
        Toast.makeText(this, "Changes discarded", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }

    public void applyClicked(View view) {
        Spinner ui_language_spinner = findViewById(R.id.ui_language_spinner);
        String ui_language = String.valueOf(ui_language_spinner.getSelectedItem());

        Spinner target_language_spinner = findViewById(R.id.target_language_spinner);
        String target_language = String.valueOf(target_language_spinner.getSelectedItem());

        if (ui_language.equals("English")) {
            UILanguageSelected = "English";
            System.out.println("UI selected is " + UILanguageSelected);
        } else if (ui_language.equals("Japanese")) {
            UILanguageSelected = "Japanese";
            System.out.println("UI selected is " + UILanguageSelected);
        } else {
            System.out.println("Error");
        }

        switch (target_language) {
            case "English":
                targetLanguageSelected = "English";
                System.out.println("The target language is " + targetLanguageSelected);
                break;
            case "Japanese":
                targetLanguageSelected = "Japanese";
                System.out.println("The target language is " + targetLanguageSelected);
                break;
            case "LeetSpeak":
                targetLanguageSelected = "LeetSpeak";
                System.out.println("The target language is " + targetLanguageSelected);
                break;
            default:
                System.out.println("Error");
                break;
        }

        Intent intent = new Intent(this,
                MainActivity.class);
        intent.putExtra("UILanguageSelected", UILanguageSelected);
        intent.putExtra("targetLanguageSelected", targetLanguageSelected);
        Toast.makeText(this, "Settings updated!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void switchClicked(View view) {
        // initiate a Switch
        Switch darkModeSwitch = findViewById(R.id.darkModeSwitch);
        // check current state of a Switch (true or false).
        Boolean switchState = darkModeSwitch.isChecked();
        System.out.println(switchState);
        if (switchState) {
            System.out.println("Turning on dark mode");
            setActivityBackgroundColor(Color.parseColor("#696969"));
            TextView text = new TextView(this);
            text.setTextColor(Color.parseColor("#fffafa"));
        } else if (!switchState) {
            System.out.println("Turning off dark mode");
            setActivityBackgroundColor(Color.parseColor("#fffafa"));
            TextView text = new TextView(this);
            text.setTextColor(Color.parseColor("#fffafa"));
        }
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
