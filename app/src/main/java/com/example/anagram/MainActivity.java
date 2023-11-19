package com.example.anagram;

import static android.view.View.OnClickListener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import utils.EditString;

public class MainActivity extends AppCompatActivity {

    private TextView editText;
    private TextView outText;
    private TextView ignoredCharacters;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.editText);
        outText = (TextView) findViewById(R.id.outText);
        button = (Button) findViewById(R.id.button);
        ignoredCharacters = (TextView) findViewById(R.id.ignoredCharacters);

        OnClickListener oclButton = new OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = editText.getText().toString();
                String ignore = ignoredCharacters.getText().toString();

                outText.setText(EditString.editString(string, ignore));

                Toast toast = Toast.makeText(getApplicationContext(),"Anagram ready", Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        button.setOnClickListener(oclButton);

    }
}


