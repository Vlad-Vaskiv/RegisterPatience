package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_message);
        // получаем объект RadioGroup
        RadioGroup radGrp = (RadioGroup)findViewById(R.id.radios);
        // обработка переключения состояния переключателя
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                TextView selection = (TextView) findViewById(R.id.selection);
                switch(id) {
                    case R.id.hiru:
                        selection.setText("Вибраний Хірург");
                        break;
                    case R.id.tera:
                        selection.setText("Вибраний Терапевт");
                        break;
                    case R.id.stom:
                        selection.setText("Вибраний Стоматолог");
                        break;
                    default:
                        break;
                }
            }});

//        // Отримуємо повідомлення з об'єкту intent
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//        // Створюємо текстове поле
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(message);
//
//        // Встановлюємо текстове поле в системі компоновки activity
//       setContentView(textView);
    }
}