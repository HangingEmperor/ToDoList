package sample;

import javafx.scene.control.CheckBox;

import java.util.Objects;

public class Task {

    private CheckBox accomplished;
    private int id;
    private String text;
    private String date;

    public Task(CheckBox accomplished, String text, String date) {
        this.accomplished = accomplished;
        this.text = text;
        this.date = date;
    }

    public Task(CheckBox accomplished, int id, String text, String date) {
        this.accomplished = accomplished;
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public CheckBox getAccomplished() {
        return accomplished;
    }

    public void setAccomplished(CheckBox accomplished) {
        this.accomplished = accomplished;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(accomplished, task.accomplished) &&
                Objects.equals(text, task.text) &&
                Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accomplished, text, date);
    }

    @Override
    public String toString() {
        return "Task{" +
                "accomplished=" + accomplished +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
