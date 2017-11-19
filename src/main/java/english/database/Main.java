package english.database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

public class Main extends JFrame implements ActionListener
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    private static List<Words> wordsList;

    public static void main(String[] args) throws SQLException
    {
        DbHandler dbHandler = new DbHandler();
        wordsList = dbHandler.getAllWords();

        // Вывод всей базы данных на косоль
        //for (Words word : wordsList) System.out.println(word.toString());
        new Main();
    }

    private final JTextArea label = new JTextArea();
    private final JTextArea labelRightOrWrong = new JTextArea("_");
    private final JTextField input = new JTextField();

    private Main ()
    {
        // Параметры окна
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

        // Параметры JTextArea. текстовое поле
        label.setEditable(false);
        label.setLineWrap(true);
        label.setText(wordsList.get(i).getEng());

        add(label, BorderLayout.NORTH);
        add(labelRightOrWrong, BorderLayout.CENTER);
        add(input, BorderLayout.SOUTH);
        input.addActionListener(this);
        input.setText("");

        setVisible(true);
    }

    // Обработчик нажатия ENTER
    private int i = 0;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            if ( input.getText().equals(wordsList.get(i).getRus()) )
            {
                label.setText( wordsList.get(++i).getEng() );
                labelRightOrWrong.setText("\t!_RIGHT_!");
            } else {
                labelRightOrWrong.setText("\t!_Wrong_!");
            }
        } catch (IndexOutOfBoundsException ex) {
            label.setText("ERROR: Конец списка массива");
        } catch (Exception ex) {
            label.setText("ERROR: Возникла какая-то неопределенная ошибка!");
        }


        input.setText("");
    }
}
