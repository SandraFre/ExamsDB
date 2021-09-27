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
    Long id;
    String questionTitle;
    String aAnswer;
    String bAnswer;
    String cAnswer;
    String correctAnswer;

    public Question(String questionTitle, String aAnswer, String bAnswer, String cAnswer, String correctAnswer) {
        this.questionTitle = questionTitle;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.correctAnswer = correctAnswer;
    }
}
