package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.EBookType;
import com.bilgeadam.repository.enums.EStatus;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@NamedQueries(
        {
                @NamedQuery(name = "findByBookType", query = "SELECT b FROM Book AS b WHERE b.bookType =: myType"),
                @NamedQuery(name = "findById", query = "SELECT b FROM Book AS b WHERE b.id =: myId"),
                @NamedQuery(name = "countBookType", query = "SELECT b.bookType, COUNT(*) FROM Book AS b GROUP BY bookType")
        }
        )
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private EBookType bookType;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.AVAILABLE;
    private int pageCount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "my_author_id", referencedColumnName = "id", nullable = false)
//    @ToString.Exclude
    private Author author;
}