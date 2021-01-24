package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindowGUI {

    private static boolean start = false;
    private static boolean end = false;
    public static JButton[] buttonsArr;
    private static GridGraphCreater gridGraph;
    private static GridGraphSearcher gridSearch;

    public static void main(String[] args) throws Exception {
        gridGraph = new GridGraphCreater(900);
        gridSearch = new GridGraphSearcher(gridGraph.getGraph());
        gridLayout();

    }

    public static void gridLayout() {
        JFrame frame = new JFrame("Flow Layout");
        buttonsArr = new JButton[900];
        for (int i = 0; i < 900; i++) {
            JButton button = new JButton();
            buttonsArr[i] = button;

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (start == false) {
                        button.setBackground(Color.GREEN);
                        button.setName("s");
                        start = true;
                        gridSearch.findStartIndex(button);

                    } else if (end == false) {
                        button.setBackground(Color.RED);
                        button.setName("e");
                        end = true;
                        gridSearch.findEndIndex(button);
                        try {
                            gridSearch.depthFirst();
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                   }
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

    public static JButton[] getButtonArray(){
        return buttonsArr;
    }
    public static void setButtonColor(int i){
        buttonsArr[i].setBackground(Color.MAGENTA);
    }
}
