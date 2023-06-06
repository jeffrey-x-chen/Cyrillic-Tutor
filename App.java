import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends JFrame {

    int vocabSize = 50;
    int count = 0;
    boolean reset = true;
    private JLabel instructionText;
    private JTextField input;
    private JButton enter;
    private JLabel feedback;
    private JButton moveOn;

    /* NOTE: for the cyrilic and english arrays to match up, the cyrilic
        word MUST MATCH UP with the INDEX of the english meaning in the
        English word array  */ 
    String[][] pronunciationMeaning = new String[3][vocabSize];

    String cyrilicWord;

    public App() {
        
        // if statement to help shrink long input of cyrilic vocab
        if (true) {
            pronunciationMeaning[0][0] = "кот";
            pronunciationMeaning[1][0] = "kot";
            pronunciationMeaning[2][0] = "cat";

            pronunciationMeaning[0][1] = "собака";
            pronunciationMeaning[1][1] = "sobaka";
            pronunciationMeaning[2][1] = "dog";

            pronunciationMeaning[0][2] = "дом";
            pronunciationMeaning[1][2] = "dom";
            pronunciationMeaning[2][2] = "house";

            pronunciationMeaning[0][3] = "мама";
            pronunciationMeaning[1][3] = "mama";
            pronunciationMeaning[2][3] = "mom";

            pronunciationMeaning[0][4] = "папа";
            pronunciationMeaning[1][4] = "papa";
            pronunciationMeaning[2][4] = "dad";

            pronunciationMeaning[0][5] = "друг";
            pronunciationMeaning[1][5] = "drug";
            pronunciationMeaning[2][5] = "friend";

            pronunciationMeaning[0][6] = "книга";
            pronunciationMeaning[1][6] = "kniga";
            pronunciationMeaning[2][6] = "book";

            pronunciationMeaning[0][7] = "школа";
            pronunciationMeaning[1][7] = "shkola";
            pronunciationMeaning[2][7] = "school";

            pronunciationMeaning[0][8] = "стол";
            pronunciationMeaning[1][8] = "stol";
            pronunciationMeaning[2][8] = "table";

            pronunciationMeaning[0][9] = "город";
            pronunciationMeaning[1][9] = "gorod";
            pronunciationMeaning[2][9] = "city";

            pronunciationMeaning[0][10] = "вода";
            pronunciationMeaning[1][10] = "voda";
            pronunciationMeaning[2][10] = "water";

            pronunciationMeaning[0][11] = "день";
            pronunciationMeaning[1][11] = "den";
            pronunciationMeaning[2][11] = "day";

            pronunciationMeaning[0][12] = "ночь";
            pronunciationMeaning[1][12] = "noch";
            pronunciationMeaning[2][12] = "night";

            pronunciationMeaning[0][13] = "солнце";
            pronunciationMeaning[1][13] = "solntse";
            pronunciationMeaning[2][13] = "sun";

            pronunciationMeaning[0][14] = "луна";
            pronunciationMeaning[1][14] = "luna";
            pronunciationMeaning[2][14] = "moon";

            pronunciationMeaning[0][15] = "ребенок";
            pronunciationMeaning[1][15] = "rebenok";
            pronunciationMeaning[2][15] = "child";

            pronunciationMeaning[0][16] = "игра";
            pronunciationMeaning[1][16] = "igra";
            pronunciationMeaning[2][16] = "game";

            pronunciationMeaning[0][17] = "еда";
            pronunciationMeaning[1][17] = "eda";
            pronunciationMeaning[2][17] = "food";

            pronunciationMeaning[0][18] = "сон";
            pronunciationMeaning[1][18] = "son";
            pronunciationMeaning[2][18] = "sleep";

            pronunciationMeaning[0][19] = "собираться";
            pronunciationMeaning[1][19] = "sobirat'sya";
            pronunciationMeaning[2][19] = "to gather";

            pronunciationMeaning[0][20] = "работа";
            pronunciationMeaning[1][20] = "rabota";
            pronunciationMeaning[2][20] = "work";

            pronunciationMeaning[0][21] = "песня";
            pronunciationMeaning[1][21] = "pesnya";
            pronunciationMeaning[2][21] = "song";

            pronunciationMeaning[0][22] = "учиться";
            pronunciationMeaning[1][22] = "uchit'sya";
            pronunciationMeaning[2][22] = "to study";

            pronunciationMeaning[0][23] = "магазин";
            pronunciationMeaning[1][23] = "magazin";
            pronunciationMeaning[2][23] = "shop";

            pronunciationMeaning[0][24] = "работник";
            pronunciationMeaning[1][24] = "rabotnik";
            pronunciationMeaning[2][24] = "worker";

            pronunciationMeaning[0][25] = "семья";
            pronunciationMeaning[1][25] = "sem'ya";
            pronunciationMeaning[2][25] = "family";

            pronunciationMeaning[0][26] = "учитель";
            pronunciationMeaning[1][26] = "uchitel'";
            pronunciationMeaning[2][26] = "teacher";

            pronunciationMeaning[0][27] = "страна";
            pronunciationMeaning[1][27] = "strana";
            pronunciationMeaning[2][27] = "country";

            pronunciationMeaning[0][28] = "любовь";
            pronunciationMeaning[1][28] = "lyubov'";
            pronunciationMeaning[2][28] = "love";

            pronunciationMeaning[0][29] = "время";
            pronunciationMeaning[1][29] = "vremya";
            pronunciationMeaning[2][29] = "time";

            pronunciationMeaning[0][30] = "говорить";
            pronunciationMeaning[1][30] = "govorit'";
            pronunciationMeaning[2][30] = "to speak";

            pronunciationMeaning[0][31] = "работать";
            pronunciationMeaning[1][31] = "rabotat'";
            pronunciationMeaning[2][31] = "to work";

            pronunciationMeaning[0][32] = "другой";
            pronunciationMeaning[1][32] = "drugoy";
            pronunciationMeaning[2][32] = "other";

            pronunciationMeaning[0][33] = "город";
            pronunciationMeaning[1][33] = "gorod";
            pronunciationMeaning[2][33] = "city";

            pronunciationMeaning[0][34] = "путешествие";
            pronunciationMeaning[1][34] = "puteshestvie";
            pronunciationMeaning[2][34] = "travel";

            pronunciationMeaning[0][35] = "вопрос";
            pronunciationMeaning[1][35] = "vopros";
            pronunciationMeaning[2][35] = "question";

            pronunciationMeaning[0][36] = "ответ";
            pronunciationMeaning[1][36] = "otvet";
            pronunciationMeaning[2][36] = "answer";

            pronunciationMeaning[0][37] = "счастливый";
            pronunciationMeaning[1][37] = "schastlivyy";
            pronunciationMeaning[2][37] = "happy";

            pronunciationMeaning[0][38] = "смеяться";
            pronunciationMeaning[1][38] = "smeyat'sya";
            pronunciationMeaning[2][38] = "to laugh";

            pronunciationMeaning[0][39] = "жизнь";
            pronunciationMeaning[1][39] = "zhizn'";
            pronunciationMeaning[2][39] = "life";

            pronunciationMeaning[0][40] = "понимать";
            pronunciationMeaning[1][40] = "ponimat'";
            pronunciationMeaning[2][40] = "to understand";

            pronunciationMeaning[0][41] = "нравиться";
            pronunciationMeaning[1][41] = "nravit'sya";
            pronunciationMeaning[2][41] = "to like";

            pronunciationMeaning[0][42] = "встреча";
            pronunciationMeaning[1][42] = "vstrecha";
            pronunciationMeaning[2][42] = "meeting";

            pronunciationMeaning[0][43] = "письмо";
            pronunciationMeaning[1][43] = "pis'mo";
            pronunciationMeaning[2][43] = "letter";

            pronunciationMeaning[0][44] = "новый";
            pronunciationMeaning[1][44] = "novyy";
            pronunciationMeaning[2][44] = "new";

            pronunciationMeaning[0][45] = "старый";
            pronunciationMeaning[1][45] = "staryy";
            pronunciationMeaning[2][45] = "old";

            pronunciationMeaning[0][46] = "важный";
            pronunciationMeaning[1][46] = "vazhnyy";
            pronunciationMeaning[2][46] = "important";

            pronunciationMeaning[0][47] = "помощь";
            pronunciationMeaning[1][47] = "pomoshch'";
            pronunciationMeaning[2][47] = "help";

            pronunciationMeaning[0][48] = "проблема";
            pronunciationMeaning[1][48] = "problema";
            pronunciationMeaning[2][48] = "problem";

            pronunciationMeaning[0][49] = "смысл";
            pronunciationMeaning[1][49] = "smysl";
            pronunciationMeaning[2][49] = "meaning";

        }
            
        int frameWidth = 800;
        int frameHeight = 700;
        setTitle("Cyrilic Alphabet Tutor");
        setSize(frameWidth, frameHeight);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //String to be displayed in instructions
        cyrilicWord = randomize();

        // Instruction text, contains cyrilic word
        instructionText = new JLabel ("<html>" + "Type the English pronunciation of [ " 
            + cyrilicWord + " ]. Click Enter when you are finished." + "</html>");
        instructionText.setBounds((int) frameWidth/25, 0, 
            (int) frameWidth, (int) frameHeight/2);
        instructionText.setFont(new Font("Courier", Font.BOLD, 20));

        // Text box to type answers in 
        input = new JTextField();
        input.setBounds((int) frameWidth/25, (int)frameHeight/2, 
            (int) (frameWidth * 0.7), 100);
        input.setFont(new Font("Courier", Font.BOLD, 20));
        
        // Setting up interactible "enter" button
        enter = new JButton("Enter");
        enter.setBounds((int) (frameWidth * 0.78), (int) frameHeight/2, 
            100, 100);
        enter.setBackground(Color.WHITE);
        enter.setOpaque(true);
        getRootPane().setDefaultButton(enter);

        add(instructionText);
        add(input);
        add(enter);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent a) {
                enter.setEnabled(false);
        
                // Popup window after enter is clicked
                JFrame popup = new JFrame();
                int popupWidth = 500;
                int popupHeight = 400;
                popup.setTitle("Feedback");
                popup.setSize(popupWidth, popupHeight);
                popup.setLayout(null);
                popup.setVisible(true);
        
                feedback = new JLabel();
                feedback.setBounds(popupWidth/100, popupHeight/100, 
                    popupWidth, popupHeight/2);
                feedback.setFont(new Font("Courier", Font.BOLD, 20));
                feedback.setText("<html>" + "Good job! Click enter or" + 
                    " the button to continue." + "</html>");
        
                moveOn = new JButton("Continue");
                moveOn.setBounds(popupWidth/100,popupHeight/100 + popupHeight/2, 
                    popupWidth/5, popupHeight/4);
                moveOn.setBackground(Color.WHITE);
                moveOn.setOpaque(true);

                popup.add(feedback);
                popup.add(moveOn);

                getRootPane().setDefaultButton(moveOn);
                moveOn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed (ActionEvent e) {
                        enter.setEnabled(true);
                        popup.dispose();
                    }
                });
        
                String newWord = randomize();
                instructionText.setText("Type the English pronunciation of [ " +
                    newWord + " ]");
                input.setText("");
            }
        }
        );    
    }

    public String randomize() {
        String returnString = "";
        int rng = (int) (Math.random() * vocabSize);
        count = rng;
        returnString = pronunciationMeaning[0][rng];
        return returnString;
    }

    public static void main (String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}