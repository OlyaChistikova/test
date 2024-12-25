package com.example.myapplication;

public class TodoItem {
    private int id; // Идентификатор задачи
    private long dateStart; // Время начала в формате timestamp
    private long dateFinish; // Время окончания в формате timestamp
    private String name; // Название задачи
    private String description; // Описание задачи

    public TodoItem(int id, long dateStart, long dateFinish, String name, String description) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.name = name;
        this.description = description;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public long getDateStart() {
        return dateStart;
    }

    public long getDateFinish() {
        return dateFinish;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}