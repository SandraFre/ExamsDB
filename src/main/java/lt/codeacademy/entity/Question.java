package lt.codeacademy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
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

    public Question(String questionTitle, String aAnswer, String bAnswer, String cAnswer, String correctAnswer) {
        this.questionTitle = questionTitle;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.correctAnswer = correctAnswer;
    }
}
