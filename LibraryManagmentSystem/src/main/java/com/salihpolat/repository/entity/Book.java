package com.salihpolat.repository.entity;

import com.salihpolat.repository.enums.EBookType;
import com.salihpolat.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated (EnumType.STRING)
    private EBookType bookType;
    @Enumerated (EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.AVAILABLE;
    private int pageCount;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "my_author_id", referencedColumnName = "id", nullable = false)
    private Author author;
}