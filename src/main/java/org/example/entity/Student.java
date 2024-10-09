
//POJO (Plain Old Java Object) — это простой Java-объект,
// который не зависит от какой-либо специфической технологии или фреймворка1. В контексте Hibernate,
// POJO используется для представления сущностей, которые будут отображаться в таблицы базы данных.
// Эти объекты содержат только поля данных и методы доступа (геттеры и сеттеры), без какой-либо
// дополнительной логики или зависимостей2.
//Использование POJO в Hibernate позволяет разработчикам работать с объектами Java, не беспокоясь
// о специфических требованиях фреймворка, что делает код более чистым и легко поддерживаемым1.

//Entity
//   В Hibernate, Entity (сущность) — это класс, который отображается на таблицу базы данных.
// Сущности используются для представления данных, которые будут сохраняться в базе данных и извлекаться
// из неё. Основные аннотации, используемые для определения сущностей в Hibernate, включают:
//@Entity: Указывает, что класс является сущностью.
//@Table: Определяет имя таблицы в базе данных, к которой будет привязана сущность.
//         Если эта аннотация не используется, Hibernate по умолчанию использует имя класса как имя таблицы.
//@Id: Обозначает первичный ключ сущности.
//@GeneratedValue: Указывает стратегию генерации значений для первичного ключа.
//@Column: Определяет имя столбца в таблице, к которому будет привязано поле класса12.

package org.example.entity;

import jakarta.persistence.*;


@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "avg_grade")
    private double avgGrade;

    public Student( String name, String surname, double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
    }
    public Student(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrate(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', surname='" + surname + "', avgGrade=" + avgGrade + "}";
    }
}
