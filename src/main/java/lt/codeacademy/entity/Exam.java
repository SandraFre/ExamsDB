package lt.codeacademy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Result> results;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "exams_questions",
            joinColumns = {
                    @JoinColumn(name = "exam_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "question_id", referencedColumnName = "id")
            })
    private Set<Question> questions;

    public Exam(String title) {
        this.title = title;
    }
}
