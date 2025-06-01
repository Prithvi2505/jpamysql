package com.example.jpaMysql.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Resume resume;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Applications> applications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Users_Jobs",
           joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "jobId")

    )
    private List<Job> jobs = new ArrayList<>();


    public User() {

    }

    public User(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public List<Applications> getApplications() {
        return applications;
    }

    public void setApplications(List<Applications> applicatons) {
        this.applications = applicatons;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
//        ", mid=" + mid +
    }
}
