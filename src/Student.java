import java.util.*;
public class Student {
    /**
     * In this class we will implement student attributes and its sub methods
     */
    private String studentId;
    private List<String> userInput;

    /**
     * Initialize student attribute
     * @param id:studentid
     */
    public Student(String id) {
        this.studentId = id;
        userInput = new ArrayList<>(); // con
    }

    /**
     * @reutrn studentId
     */
    public String getId() {
        return studentId;
    }

    /**
     * @param userInput: initialize userInput
     */
    public void submitAnswer(List<String> userInput) {
        this.userInput = userInput;
    }

    /**
     * @return userInput
     */
    public List<String> getUserInput() {
        return userInput;
    }
}

