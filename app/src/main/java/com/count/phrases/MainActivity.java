package com.count.phrases;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.count.phrases.domain.BusinessException;
import com.count.phrases.domain.Counter;
import com.testapp.testapp.R;


public class MainActivity extends Activity {

    private Counter counter = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countPhrase(View view) {
        try {
            EditText phraseEdit = (EditText) findViewById(R.id.phrase);

            String countResult = counter.processText(phraseEdit.getText());

            setResultText(countResult);

        } catch (BusinessException e) {
            setErrorText(e.getMessage());
        }
    }

    private TextView setResultText(String message) {
        TextView label = (TextView) findViewById(R.id.count_result);
        label.setText(message);
        label.setTextColor(Color.BLACK);
        return label;
    }

    public void setErrorText(String errorText) {
        setResultText(errorText).setTextColor(Color.RED);
    }
}
