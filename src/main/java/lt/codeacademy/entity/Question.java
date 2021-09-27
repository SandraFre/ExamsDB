package lt.codeacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String questionTitle;
    private String aAnswer;
    private String bAnswer;
    private String cAnswer;
    private String correctAnswer;
    @ManyToMany (mappedBy = "questions", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Exam> exams;

    public Question(String questionTitle, String aAnswer, String bAnswer, String cAnswer, String correctAnswer) {
        this.questionTitle = questionTitle;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.correctAnswer = correctAnswer;
    }
}
