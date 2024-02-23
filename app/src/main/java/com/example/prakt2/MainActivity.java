package com.example.prakt2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
    }

    public void onButtonClick(View view) {
        // Создаем Intent для запуска SecondActivity
        Intent intent = new Intent(this, SecondActivity.class);
        // Получаем текст из EditText
        EditText editText = findViewById(R.id.editText);
        String textToSend = editText.getText().toString();
        // Передаем текст в SecondActivity через Intent
        intent.putExtra("textFromMainActivity", textToSend);
        // Запускаем SecondActivity с ожиданием результата
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Получаем текст из результата, переданного из SecondActivity
            String result = data.getStringExtra("resultKey");
            // Устанавливаем текст в TextView
            textView.setText(result);
        }
    }
}

