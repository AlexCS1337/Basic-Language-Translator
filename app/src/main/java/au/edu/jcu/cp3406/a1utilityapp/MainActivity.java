package au.edu.jcu.cp3406.a1utilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SettingsActivity sa = new SettingsActivity();
    private final String defaultUILanguage = "en";
    private final String defaultTargetLanguage = "Japanese";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String languageToLoad  = sa.UILanguageSelected; // your language
//        Locale locale = new Locale(languageToLoad);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config,
//                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
        sa.UILanguageSelected = getIntent().getStringExtra("UISelectedLanguage");
        if (sa.UILanguageSelected == null) {
            sa.UILanguageSelected = defaultUILanguage;
        }
        sa.targetLanguageSelected = getIntent().getStringExtra("targetLanguageSelected");
        if (sa.targetLanguageSelected == null) {
            sa.targetLanguageSelected = defaultTargetLanguage;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        sa.UILanguageSelected = getIntent().getStringExtra("UISelectedLanguage");
        sa.targetLanguageSelected = getIntent().getStringExtra("targetLanguageSelected");
//        outState.putString("UILanguageSelected", sa.UILanguageSelected);
//        outState.putString("targetLanguageSelected", sa.targetLanguageSelected);
    }

    public void translateText(View view) {
        EditText input = findViewById(R.id.editText);
        TextView output = findViewById(R.id.translatedTextView);
        String text = input.getText().toString();
        System.out.println("Given text is " + text);
        System.out.println("The target language is " + sa.targetLanguageSelected + "\nThe UI language is "+ sa.UILanguageSelected);
        switch (sa.targetLanguageSelected) {
            case "English":
                if (text.equals("こんにちは世界")) {
                    String translatedText = "Hello world";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("おはようございます")) {
                    String translatedText = "Good morning";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("こんにちは")) {
                    String translatedText = "Hello / Good Afternoon";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("こんばんは")) {
                    String translatedText = "Good Evening";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("はい")) {
                    String translatedText = "Yes";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("いいえ")) {
                    String translatedText = "No";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("さよなら")) {
                    String translatedText = "Goodbye";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("ありがとうございます")) {
                    String translatedText = "Thank you";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("どういたしまして")) {
                    String translatedText = "You're welcome";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else {
                    System.out.println("No translation for given text");
                    Toast.makeText(this, "No translation for given text.", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Japanese":
                if (text.equals("Hello world") || text.equals("hello world")) {
                    String translatedText = "こんにちは世界！\nkonnichiwa sekai";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Good morning") || text.equals("good morning")) {
                    String translatedText = "おはようございます\nohayougozaimasu";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Hello") || text.equals("hello") || text.equals("Good afternoon") || text.equals("good afternoon")) {
                    String translatedText = "こんにちは\nkonnichiwa";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Good evening") || text.equals("good evening")) {
                    String translatedText = "こんばんは\nkonbanwa";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Yes") || text.equals("yes")) {
                    String translatedText = "はい\nhai";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("No") || text.equals("no")) {
                    String translatedText = "いいえ\niie";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.contains("Bye") || text.contains("bye")) {
                    String translatedText = "さよなら\nsayonara";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.contains("Thank") || text.contains("thank")) {
                    String translatedText = "ありがとうございます\narigatougozaimasu";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.contains("Welcome") || text.contains("welcome")) {
                    String translatedText = "どういたしまして\ndouitashimashite";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else {
                    System.out.println("No translation for given text");
                    Toast.makeText(this, "No translation for given text.", Toast.LENGTH_SHORT).show();
                }
                break;
            case "LeetSpeak":
                if (text.equals("Hello world") || text.equals("hello world")) {
                    String translatedText = "h3ll0 w0rlD！";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Good morning") || text.equals("good morning")) {
                    String translatedText = "g00d m0rn1nG!";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Hello") || text.equals("hello")) {
                    String translatedText = "h3ll0";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Good evening") || text.equals("good evening")) {
                    String translatedText = "g00d ev3n1nG!";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("Yes") || text.equals("yes")) {
                    String translatedText = "y3s";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.equals("No") || text.equals("no")) {
                    String translatedText = "n0!";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.contains("Bye") || text.contains("bye")) {
                    String translatedText = "by3 n00b";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.contains("Thank") || text.contains("thank")) {
                    String translatedText = "th4nk$ y0u";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else if (text.contains("Welcome") || text.contains("welcome")) {
                    String translatedText = "y0ur Welc0m3!";
                    output.setText(translatedText);
                    System.out.println("translated text is" + translatedText);
                } else {
                    System.out.println("No translation for given text");
                    Toast.makeText(this, "No translation for given text.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clearClicked(View view) {
        TextView textView = findViewById(R.id.translatedTextView);
        String clearedText = "";
        textView.setText(clearedText);
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent(this,
                SettingsActivity.class);

        //startActivity(intent);
        startActivityForResult(intent, SettingsActivity.SETTINGS_REQUEST);
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
        }
        else if (!switchState) {
            System.out.println("Turning off dark mode");
            setActivityBackgroundColor(Color.parseColor("#fffafa"));

            TextView text = new TextView(this);
            text.setTextColor(Color.parseColor("#010203"));
        }
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
