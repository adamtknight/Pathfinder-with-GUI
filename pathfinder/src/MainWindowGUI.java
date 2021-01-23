import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindowGUI  {  

	public static void main(String[] args) {    
      gridLayout();
        
    }  
    public static void gridLayout(){
        JFrame frame = new JFrame("Flow Layout");
        JButton[] buttonsArr = new JButton[900];
        for(int i = 0; i < 900; i++){
            JButton button = new JButton();
            buttonsArr[i] = button;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   button.setBackground(Color.BLACK);
                }
             });
        }
        for(int i = 0; i < 900; i++){
           frame.add(buttonsArr[i]);
        }
        JPanel header = new JPanel();
        frame.add(header);
        frame.setLayout(new GridLayout(30,30));
        frame.setSize(1000,1000);  
        frame.setVisible(true);  
    }
}
