package ua.stu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InfoFrame extends JDialog {
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textAreaInfo;
    private JLabel Label;

    private BufferedImage image = null;

    {
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("photo.jpg"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private JPanel contentPane = new JPanel() {
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D) graphics;
            Image scaleImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            graphics2D.drawImage(scaleImage, 20, 20, 200,265,this);
        }
    };

    public InfoFrame() {
        setUiProperties();
        setEvents();
    }

    private void setUiProperties() {
        setContentPane(contentPane);
        setModal(true);
        setBounds(200, 200, 490, 335);
        setMinimumSize(new Dimension(490, this.getWidth() - 180));
        getRootPane().setDefaultButton(buttonOK);

        setTitle("Information about developer");
        StringBuffer info = new StringBuffer("");
        info.append("Розробник програми:\n");
        info.append("Ладоха Анастасія Василівна\n");
        info.append("Студентка групи ПІ-181\n");
        info.append("nastia.ladoha@gmail.com\n");
        info.append("+380935375568\n");

        setResizable(false);
        GridBagLayout layout = new GridBagLayout();
        contentPane.setLayout(layout);
        textAreaInfo.setSize(new Dimension(400, 100));
        textAreaInfo.setMargin(new Insets(25, 10, 10, 10));
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST; //bottom of space
        c.insets = new Insets(20, 210, 10, 0);  //top padding
        c.gridx = 2;
        contentPane.add(textAreaInfo, c);
        buttonOK.setMaximumSize(new Dimension(400, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST; //bottom of space
        c.insets = new Insets(10, 210, 10, 0);  //top padding
        c.gridx = 2;
        c.gridy = 1;
        contentPane.add(buttonOK, c);
        textAreaInfo.setText(info.toString());
    }

    public void setEvents() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        InfoFrame dialog = new InfoFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
