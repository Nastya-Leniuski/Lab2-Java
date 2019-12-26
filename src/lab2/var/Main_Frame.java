package lab2.var;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.image.ImageObserver;
import java.lang.StrictMath;
import java.text.AttributedCharacterIterator;

import static java.lang.Math.*;


public class Main_Frame extends JFrame {
    private static final int width = 1300;
    private static final int height = 500;
    private JTextField result_field;
    private JTextField x_field;
    private JTextField y_field;
    private JTextField z_field;
    private JLabel image;
    private ButtonGroup radioButtons = new ButtonGroup();
    private Box formula_type = Box.createHorizontalBox();
    private ButtonGroup radioMemoryButtons = new ButtonGroup();
    private Box hBoxMemoryType = Box.createHorizontalBox();
    private JTextField memoryTextField;
    int formula_number = 1;
    private int memoryId= 1;

    private Double mem1 = new Double(0);
    private Double mem2 = new Double(0);
    private Double mem3 = new Double(0);

    public Double formula1(Double x, Double y, Double z)
    {
        if (y <= 0)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "y должен быть положительным", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if ((pow(x,2)+ sin(z)+exp(cos(z))) < 0)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "выражение под корнем должно быть положительным", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        return sin(log(y)+ sin(Math.PI*pow(y,2)))* pow(pow(x,2)+ sin(z)+exp(cos(z)),1/4);
    }
    public Double formula2(Double x, Double y, Double z)
    {
        if (y == -1)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "y должен не ровняться -1", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if (x <= 0)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "x должен быть положительным", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if ((exp(cos(x))+pow(sin(Math.PI*z),2)) < 0)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "выражение под корнем должно быть положительным", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        return pow(cos(exp(x))+log(pow(1+y,2))+pow(exp(cos(x))+pow(sin(Math.PI*z),2),1/2)+pow(1/x,1/2)+cos(pow(y,2)),sin(z));
    }

    private void addMemoryRadioButton (String buttonName, final int memoryId)	{         // радиокнопки для памяти
        JRadioButton button = new JRadioButton(buttonName);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event)	{
                Main_Frame.this.memoryId = memoryId;
                if (memoryId == 1)	memoryTextField.setText(mem1.toString());
                if (memoryId == 2)	memoryTextField.setText(mem2.toString());
                if (memoryId == 3)	memoryTextField.setText(mem3.toString());
            }
        });

        radioMemoryButtons.add(button);
        hBoxMemoryType.add(button);
    }
    private void addRadioButton(String name, final int formula_number)           // радиокнопки для формул
    {
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Main_Frame.this.formula_number = formula_number;
                if (formula_number == 1)	image.setIcon(new ImageIcon(MainFrame1.class.getResource("formula_1.jpg")));
                if (formula_number == 2) image.setIcon(new ImageIcon(MainFrame1.class.getResource("formula_2.jpg")));
            }
        });
        radioButtons.add(button);
        formula_type.add(button);
    } }