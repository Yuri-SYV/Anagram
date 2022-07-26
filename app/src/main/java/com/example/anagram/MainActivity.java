package com.example.anagram;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView editText;
    TextView outText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.editText);
        outText = (TextView) findViewById(R.id.outText);
        button = (Button) findViewById(R.id.button);

        OnClickListener oclButton = new OnClickListener() {
            @Override
            public void onClick(View view) {

                String string = editText.getText().toString();
                String[] strArray = string.split(" ");

                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < strArray.length; i++) {
                    char[] str1 = strArray[i].toCharArray();
                    for (int j = str1.length - 1; j >= 0; j--) {
                        builder.append(str1[j]);

                        outText.setText(builder.toString());
                    }
                }
            }
        };

        button.setOnClickListener(oclButton);
    }
}
