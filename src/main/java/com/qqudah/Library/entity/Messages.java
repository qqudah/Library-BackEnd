package com.qqudah.Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String question;

    private String adminEmail;

    @Column(columnDefinition = "TEXT")
    private String response;

    private Boolean closed = false;
}

