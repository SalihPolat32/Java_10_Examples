package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class Like extends BaseEntity {

    @Id
    private String id;

    private String userId;

    private String postId; // Beğenilen post

    private String commentId; // Beğenilen Yorum

    private String username;

    private String userAvatar;
}