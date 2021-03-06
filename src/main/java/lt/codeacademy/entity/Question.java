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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question_title")
    private String questionTitle;
    @Column(name = "a_answer")
    private String aAnswer;
    @Column(name = "b_answer")
    private String bAnswer;
    @Column(name = "c_answer")
    private String cAnswer;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "exam_id")
    private Exam exam;
    @OneToMany (mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<StudentAnswer> answers;

    public Question(String questionTitle, String aAnswer, String bAnswer, String cAnswer, String correctAnswer) {
        this.questionTitle = questionTitle;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id + '\n' +
                " '" + questionTitle + '\'' + '\n' +
                ", a) '" + aAnswer + '\'' + '\n' +
                ", b) '" + bAnswer + '\'' + '\n' +
                ", c) '" + cAnswer + '\'' + '\n' +
                ", correct answer: '" + correctAnswer + '\'' +
                '}';
    }
}
