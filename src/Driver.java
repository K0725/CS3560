import java.util.*;
public class Driver {
    /*
    Assignment features
    - multiple choice queston -> user can select more than one choices
    - single choice question -> user can only select one choice
    *User feature -> unique id (string)

    *Voting Service -> only one submission per student so if there are multiple take the last

    *SimulationDriver to automatically simulate the whole process. Basically,
    the driver will 1) create a question type and configure the answers; 2) configure the
    question for iVote Service; 3) randomly generate a number students and the answers; 4)
    submit all the students’ answers to iVote Service; 5) call the Voting Service output
    function to display the result
     */
    public static void main(String[] args) {

        Random random = new Random();


        int numStudents = random.nextInt(60);
        // get the students list from the @generateStudent()
        List<Student> students = generateStudents(numStudents);

        // Hard coded its Question type and its choices
        Question question1 = new Question("multiple-choice", Arrays.asList("A", "B", "C", "D"), true);
        VotingService test1 = new VotingService(); // Create Object of the Voting Service
        System.out.println(question1.getType()); // getting its questions type -> "multiple choices"
        test1.configureQuestion(question1);  //call configureQuestion
        runVoting(test1, students); // call simulateVoting
        test1.displayResult();

        //Question 2
        Question question2 = new Question("single-choice", Arrays.asList("1. Right", "2. Wrong"), false);
        VotingService test2 = new VotingService();
        test2.configureQuestion(question2);
        System.out.println(question2.getType());
        runVoting(test2, students);
        test2.displayResult();

        // Question3
        Question question3 = new Question("single Choice", Arrays.asList("1: Right", "2: Wrong"), false);
        VotingService test3 = new VotingService();
        test3.configureQuestion(question3);
        System.out.println(question3.getType());
        runVoting(test3, students);
        test3.displayResult();
    }

    /**
     *
     * @param votingService: Obj of votingService
     * @param students: getting its student obj
     */
    private static void runVoting(VotingService votingService, List<Student> students) {
        for (Student student : students) {
            List<String> candidateAnswers = votingService.getQuestion().getUserAnswer();
            String choice = candidateAnswers.get(new Random().nextInt(candidateAnswers.size()));
            List<String> selectedChoice = new ArrayList<>();
            selectedChoice.add(choice);

            //submit answer
            student.submitAnswer(selectedChoice);
            votingService.acceptSubmission(student);
        }
    }

    /**
     * @param numStudents : randomly generate num of student
     * @return students
     *
     * Initialize the students list
     * Add the new Students with their studentId
     */
    private static List<Student> generateStudents(int numStudents) {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
            students.add(new Student("studentId" + i));
        }

        return students;
    }
}
