package com.example.anagram;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
               editString();
            }

            public void editString() {
                String string = editText.getText().toString();
                String[] strArray = string.split(" ");

                StringBuilder builder = new StringBuilder();

                for (int n = 0; n < strArray.length; n++) {
                    char[] s = strArray[n].toCharArray();

                    reverse(s);

                    String revStr = new String(s);
                    builder.append(revStr);
                    builder.append(" ");
                    outText.setText(builder.toString());
                }
            }

                public void reverse(char[] s) {
                    String ignore = ignoredCharacters.getText().toString();
                    char[] temp = new char[s.length];           // creating character array
                    int x = 0;
                    for (int i = 0; i < s.length; i++) {
                        if (ignore.indexOf(s[i]) < 0) {
                            temp[x] = s[i];
                            x++;
                        }
                    }

                    rev(temp, 0, x);                          // reversing the character array

                    x = 0;
                    for (int i = 0; i < s.length; i++) {        // updating the original string
                        if (ignore.indexOf(s[i]) < 0) {
                            s[i] = temp[x];
                            x++;
                        }
                    }
                }

                public void rev(char s[], int l, int r){        // reversal array
                    for (int i = l; i < r / 2; i++) {
                        char temp = s[i];
                        s[i] = s[r - 1 - i];
                        s[r - 1 - i] = temp;
                    }
                }

        };
        button.setOnClickListener(oclButton);
    }
}

