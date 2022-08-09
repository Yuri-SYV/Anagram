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
    private Button button;

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
                editString();
            }

            public void editString() {
                String string = editText.getText().toString();
                String[] strArray = string.split(" ");
                StringBuilder builder = new StringBuilder();


                for (int n = 0; n < strArray.length; n++) {

                    char[] str1 = strArray[n].toCharArray();


                    char[] str2 = new char[str1.length];

                    for (int i = 0; i < str1.length; i++) {

                        for (int j = str1.length - i - 1; j >= 0; j--) {
                            if (str1[i] == '0' || str1[i] == '1' || str1[i] == '2' || str1[i] == '3' || str1[i] == '4' || str1[i] == '5' || str1[i] == '6' || str1[i] == '7' || str1[i] == '8' || str1[i] == '9') {

                                str2[i] = str1[i];

                            } else {

                                str2[j] = str1[i];
                            }
                            i++;
                        }
                        builder.append(str2);
                        builder.append(" ");

                    }
                    outText.setText(builder.toString());
                }
            }
        };
        button.setOnClickListener(oclButton);
    }
}
