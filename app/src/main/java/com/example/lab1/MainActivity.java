package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent; // подключаем класс Intent
import android.os.Bundle;
import android.view.View; // подключаем класс View для обработки нажатия кнопки
import android.widget.EditText; // подключаем класс EditText
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Відправити повідомлення, натиснувши на кнопку "Відправити"
    public void reg(View view) {
        Intent intent = new Intent(this, Registration.class);
        // запуск activity
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Получаем текстовое поле в текущей Activity
        EditText editText = (EditText) findViewById(R.id.log_name);
        // Получае текст данного текстового поля
        String message = editText.getText().toString();
        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
        intent.putExtra(EXTRA_MESSAGE, message);
        // запуск activity
        startActivity(intent);
    }
}