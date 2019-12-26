package lab2.var;
//Импортируются классы, используемые в приложении
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//Главный класс приложения, он же класс фрейма
public class MainFrame1 extends JFrame {

    //Размеры окна приложения в виде констант
    private static final int WIDTH = 600;
    private static final int HEIGHT = 420;

    //Текстовые поля для считывания значений переменных,
//как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;

    //Для фотки
    private JLabel imageLabel;

    //Текстовое поле для отображения результата,
//как компонент, совместно используемый в различных методах
    private JTextField memoryTextField;
    private JTextField resultFieldText;

    //Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioMemoryButtons = new ButtonGroup();

    //Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hBoxMemoryType = Box.createHorizontalBox();


    //Переменная, указывающая, какая из формул является  активной  в  данный  момент
    private int formulaId = 1;
    private int memoryId = 1;

    private Double mem1 = new Double(0);
    private Double mem2 = new Double(0);
    private Double mem3 = new Double(0);

    //Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) {

        if (x == 0)	{
            JOptionPane.showMessageDialog(MainFrame1.this,
                    "x не может равняться нулю", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        if (y == 0)	{
            JOptionPane.showMessageDialog(MainFrame1.this,
                    "y не может равняться нулю", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return Math.pow(Math.pow(Math.log(1+x),2) + Math.cos(Math.pow(Math.PI*z, 3)), Math.sin(y)) + Math.pow(Math.pow(Math.E, Math.pow(x, 2)) + Math.cos(Math.pow(Math.E,z)) + Math.pow(1/y, 1/2), 1/x);
    }

    //Формула №2 для рассчёта
    public Double calculate2(Double x, Double y, Double z) {
        if (x == 0)	{
            JOptionPane.showMessageDialog(MainFrame1.this,
                    "x не может равняться нулю", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return Math.pow(Math.cos(Math.pow(Math.PI*x, 3)) + Math.pow(Math.log(1+y), 2), 4)*(Math.pow(Math.E, Math.pow(z, 2)) + Math.pow(1/x, 1/2) + Math.cos(Math.pow(Math.E, y)));
    }
}
