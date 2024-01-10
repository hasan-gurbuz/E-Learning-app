package com.example.Elearn.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserCourseProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @JoinTable(
            name = "user_course_progress_lessons",
            joinColumns = @JoinColumn(name = "user_course_progress_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private List<Lesson> completedLessons;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
