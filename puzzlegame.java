import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  

public class puzzlegame extends JFrame implements ActionListener{  
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,next;    
    
    puzzlegame() {  
        super("Puzzle Game ");  
        b1 = new JButton("1");  
        b2 = new JButton(" ");  
        b3 = new JButton("3");  
        b4 = new JButton("4");  
        b5 = new JButton("5");  
        b6 = new JButton("6");  
        b7 = new JButton("7");  
        b8 = new JButton("8");  
        b9 = new JButton("2");  
        next = new JButton("Next");  

        b1.setBounds(10, 30, 50, 40);  
        b2.setBounds(70, 30, 50, 40);  
        b3.setBounds(130, 30, 50, 40);  
        b4.setBounds(10, 80, 50, 40);  
        b5.setBounds(70, 80, 50, 40);  
        b6.setBounds(130, 80, 50, 40);  
        b7.setBounds(10, 130, 50, 40);  
        b8.setBounds(70, 130, 50, 40);  
        b9.setBounds(130, 130, 50, 40);  
        next.setBounds(70, 200, 100, 40);  
         

        add(b1); add(b2); add(b3); add(b4); add(b5); add(b6); add(b7); add(b8); add(b9); add(next);  

        b1.addActionListener(this);  
        b2.addActionListener(this);  
        b3.addActionListener(this);  
        b4.addActionListener(this);  
        b5.addActionListener(this);  
        b6.addActionListener(this);  
        b7.addActionListener(this);  
        b8.addActionListener(this);  
        b9.addActionListener(this);  
        next.addActionListener(this);  

        next.setBackground(Color.black);  
        next.setForeground(Color.green);  
        setSize(250, 300);  
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  

    public void actionPerformed(ActionEvent e) {  
        if(e.getSource() == next) {  
            shufflePuzzle();  
        } else {  
            JButton button = (JButton)e.getSource();  
            moveButton(button);  
        }  
        checkWinCondition();  
    }  

    private void shufflePuzzle() {
        String temp = b4.getText();  
        b4.setText(b9.getText());  
        b9.setText(temp);  
        temp = b1.getText();  
        b1.setText(b5.getText());  
        b5.setText(temp);  
        temp = b2.getText();  
        b2.setText(b7.getText());  
        b7.setText(temp);  
    }

    private void moveButton(JButton button) {
        String text = button.getText();  
        if(b1.getText().equals(" ")) swapButtons(button, b1);
        else if(b2.getText().equals(" ")) swapButtons(button, b2);
        else if(b3.getText().equals(" ")) swapButtons(button, b3);
        else if(b4.getText().equals(" ")) swapButtons(button, b4);
        else if(b5.getText().equals(" ")) swapButtons(button, b5);
        else if(b6.getText().equals(" ")) swapButtons(button, b6);
        else if(b7.getText().equals(" ")) swapButtons(button, b7);
        else if(b8.getText().equals(" ")) swapButtons(button, b8);
        else if(b9.getText().equals(" ")) swapButtons(button, b9);
    }

    private void swapButtons(JButton b1, JButton b2) {
        String temp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(temp);
    }

    private void checkWinCondition() {
        if(b1.getText().equals("1") && b2.getText().equals("2") && b3.getText().equals("3") && 
           b4.getText().equals("4") && b5.getText().equals("5") && b6.getText().equals("6") && 
           b7.getText().equals("7") && b8.getText().equals("8") && b9.getText().equals(" ")) {  
            JOptionPane.showMessageDialog(puzzlegame.this, "!!!You Won!!!");  
        }
    }

    public static void main(String[] args) {  
        new puzzlegame();  
    }  
}
