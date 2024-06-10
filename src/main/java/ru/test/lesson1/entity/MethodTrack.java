package ru.test.lesson1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "methodtrack")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class MethodTrack {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "methodname")
    private String methodName;

    @Column(name = "annotationabovemethod")
    private String annotationAboveMethod;

    @Column(name = "classname")
    private String className;

    @Column(name = "worktime")
    private long workTime;
}
