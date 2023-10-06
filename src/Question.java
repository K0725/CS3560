import java.util.*;
public class Question {
    // two type of the question  - Right or wrong or multiple choices

    private String type;
    private List<String> userMultipleAnswer;
    private boolean isMultiple;

    /**
     *
     * @param type : question type
     * @param userMultipleAnswer : multiple Question contains("a, b, c, d")
     * @param isMultiple: True or False
     */
    public Question(String type, List<String> userMultipleAnswer, boolean isMultiple) {
        this.type = type;
        this.userMultipleAnswer = userMultipleAnswer;
        this.isMultiple = isMultiple;
    }

    /**
     * @return type: String
     */
    public String getType() {
        return type;
    }

    /**
     * @return userMultipleAnswer: List<string>
     */
    public List<String> getUserAnswer() {
        return userMultipleAnswer;
    }

    /**
     * @return isMultiple: boolean
     */
    public boolean isMultipleAnswer() {
        return isMultiple;
    }

}
