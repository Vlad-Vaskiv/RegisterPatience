package com.example.lab1.Main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent; // подключаем класс Intent
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View; // подключаем класс View для обработки нажатия кнопки
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText; // подключаем класс EditText
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.example.lab1.Menu.AboutFragment;
import com.example.lab1.Menu.DatabaseHelper;
import com.example.lab1.Menu.DisplayMessageActivity;
import com.example.lab1.Menu.Registration;
import com.example.lab1.Menu.RegistrationFragment;
import com.example.lab1.Menu.SelectdoctorFragment;
import com.example.lab1.Menu.UserActivity;
import com.example.lab1.Menu.UsernameViewModel;
import com.example.lab1.R;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    public com.example.lab1.Timer timer = new com.example.lab1.Timer();
    public final static String K_REV = "k_rev";
    public int revenue=0;
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    ListView userList;
    TextView header;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.i("Opened MainActivity");
        timer.startTimerTotal();
        if (savedInstanceState!=null)
        {
            revenue = savedInstanceState.getInt(K_REV, 1);
        }

        header = (TextView)findViewById(R.id.showUsername);
        userList = (ListView)findViewById(R.id.list);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        databaseHelper = new DatabaseHelper(getApplicationContext());

        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lists);
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, doctors);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        //TextView usernameTextView = (TextView)findViewById(R.id.showUsername);
      //  Button usernameButton = (Button)findViewById(R.id.butuser);

//        usernameButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                createUsername();
//            }
//        });
       // UsernameViewModel usernameViewModel = new ViewModelProvider(this).get(UsernameViewModel.class);
      //  usernameViewModel.createUsername();

    }

//    public void createUsername(){
//        usernameViewModel.createUsername();
//    }

    private void setInitialData(){

        doctors.add(new Doctor ("Віктор", "Хірург", R.drawable.hir));
        doctors.add(new Doctor ("Олена", "Терапевт", R.drawable.tera));
        doctors.add(new Doctor ("Олег", "Стоматолог", R.drawable.sto));
        doctors.add(new Doctor ("Ольга", "Психотерапевт", R.drawable.ps));
        doctors.add(new Doctor ("Марина", "Окуліст", R.drawable.ok));
    }

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
        Timber.i("Select button login");
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        TextView headerView = (TextView) findViewById(R.id.header);
        switch(id){
            case R.id.reg_settings :
                Intent intent = new Intent(this, Registration.class);
                startActivity(intent);
                Timber.i("Select button in menu Registration");
                return true;
            case R.id.doc_settings:
                Intent intent1 = new Intent(this, DisplayMessageActivity.class);
                startActivity(intent1);
                Timber.i("Select button in menu Doctor");
                return true;
            case R.id.exit:
                Timber.i("Select button in menu Exit");
                onDestroy();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ChangeFragment(View view){
        Fragment fragment;

        if(view == findViewById(R.id.rbutton)){
            fragment = new RegistrationFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listFragment, fragment);
            ft.commit();
            Timber.i("Change fragment registration");
        }
        if(view == findViewById(R.id.abutton)){
            fragment = new AboutFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listFragment, fragment);
            ft.commit();
            Timber.i("Change fragment about me");
        }
        if(view == findViewById(R.id.cbutton)){
            fragment = new SelectdoctorFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listFragment, fragment);
            ft.commit();
            Timber.i("Change fragment select doctor");
        }

    }


    @Override
    public void onStart(){
        super.onStart();
        Timber.i("onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Timber.i("onResume");


        // открываем подключение
        db = databaseHelper.getReadableDatabase();

        //получаем данные из бд в виде курсора
        userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLE, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[] {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_YEAR};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        header.setText("Найдено элементов: " + String.valueOf(userCursor.getCount()));
        userList.setAdapter(userAdapter);
    }

    public void add(View view){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause(){
        super.onPause();
        Timber.i("onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy");
        timer.stopTimerTotal();
        db.close();
        userCursor.close();
    }

    @Override
    public void onStop(){
        super.onStop();
        Timber.i("onStop");
    }

    public void onClick(View view){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER)");
        db.execSQL("INSERT INTO users VALUES ('Vlad Vaskivchuk', 20);");

        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        TextView textView = (TextView) findViewById(R.id.showUsername);
        if(query.moveToFirst()){
            do{
                String name = query.getString(0);
                int age = query.getInt(1);
                textView.append("Name: " + name + " Age: " + age + "\n");
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
    }

}