package com.example.artoy.lab1_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoActivity extends AppCompatActivity {

    private EditText finish;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        finish = (EditText) findViewById(R.id.finish);
        back = (Button) findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", finish.getText().toString());
                setResult(666, intent);
                finish();
            }
        });

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(email);
        finish.setText(builder.toString());
    }


}
