package com.example.myapplication;


import android.os.Bundle;
import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private List<TodoItem> todoList;
    private long selectedDate; // Для хранения выбранной даты

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        recyclerView = findViewById(R.id.recyclerView);

        todoList = new ArrayList<>();
        populateInitialData(); // Заполняем данными по умолчанию

        adapter = new TodoAdapter(todoList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Получаем выбранную дату в формате timestamp
            selectedDate = getTimestamp(year, month, dayOfMonth);
            updateTodoList(); // Обновляем список дел в соответствии с выбранной датой
        });
    }

    private void populateInitialData() {
        // Это только пример, вы можете загружать данные из базы данных или другого источника
        todoList.add(new TodoItem(1, selectedDate + (14 * 60 * 60 * 1000), selectedDate + (15 * 60 * 60 * 1000), "Задача 1", "Описание задачи 1"));
        todoList.add(new TodoItem(2, selectedDate + (16 * 60 * 60 * 1000), selectedDate + (17 * 60 * 60 * 1000), "Задача 2", "Описание задачи 2"));
        todoList.add(new TodoItem(3, selectedDate + (18 * 60 * 60 * 1000), selectedDate + (19 * 60 * 60 * 1000), "Задача 3", "Описание задачи 3"));
    }

    // Метод для получения timestamp на основе года, месяца и дня
    private long getTimestamp(int year, int month, int dayOfMonth) {
        // Учтите, что month в Calendar начинается с 0.
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    private void updateTodoList() {
        // Здесь очистите предыдущий список и снова заполните его заданиями
        todoList.clear();
        populateInitialData(); // В данном примере просто обновляем задачи на текущий день
        adapter.notifyDataSetChanged();
    }
}