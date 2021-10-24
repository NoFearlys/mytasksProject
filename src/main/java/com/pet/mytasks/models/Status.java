package com.pet.mytasks.models;

public enum Status {
    NOTHING (1, "Пусто"),
    WAITING (2, "Ожидается"),
    OPERATION (3, "В работе"),
    SENT (4, "Отправлено"),
    RECEIVED (5, "Получено"),
    PAID (6, "Оплачено");

    int id;
    String title;

    Status(int id, String title){
        this.id=id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
