package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import javax.swing.*;

import Graph.Vertex;

public class MainWindowGUI {

    private static boolean start = false;
    private static boolean end = false;
    public static JButton[] buttonsArr;
    private static GridGraphCreater gridGraph;
    private static GridGraphSearcher gridSearch;
    static boolean diskstraSearch = true;
    static boolean breathSearch = false;
    static boolean depthSearch = false;
    static JFrame frame1;
    static JFrame frame2;

    public static void main(String[] args) throws Exception {
        gridGraph = new GridGraphCreater(4900);
        gridSearch = new GridGraphSearcher(gridGraph.getGraph());
        gridLayout();
        controls();

    }

    public static void gridLayout() {
        frame1 = new JFrame("Path Finder");
        buttonsArr = new JButton[4900];
        for (int i = 0; i < 4900; i++) {
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
                        ArrayList<Vertex<Integer>> path = null;
                        try {
                            if(breathSearch){
                                path = gridSearch.breadthFirst();
                            }else if(depthSearch){
                                path = gridSearch.depthFirst();
                            }else if(diskstraSearch){
                                path = gridSearch.dijkstra();
                            }
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        ArrayList<Integer> changecolors = gridSearch.getVisited();
                        for (int i = 0; i < changecolors.size(); i++) {
                            buttonsArr[changecolors.get(i)].setBackground(Color.LIGHT_GRAY);
                            new Timer(100, null).start();
                        }
                        for (int i = 0; i < path.size(); i++) {
                            buttonsArr[path.get(i).getData()].setBackground(Color.BLUE);

                        }

                    }
                }
            });
        }
        for (int i = 0; i < 4900; i++) {
            frame1.add(buttonsArr[i]);
        }

        frame1.setLayout(new GridLayout(71, 70));
        frame1.setSize(1000, 1000);
        frame1.setVisible(true);
    }

    public static void controls() {
        frame2 = new JFrame("Controls");
        frame2.setLayout(new GridLayout(2, 5));
        JButton dikstra = new JButton("Dikstra");
        dikstra.setBackground(Color.GREEN);
        JButton breathFirst = new JButton("Breadth");
        breathFirst.setBackground(Color.LIGHT_GRAY);
        JButton depthFirst = new JButton("Depth");
        depthFirst.setBackground(Color.LIGHT_GRAY);
        JButton reset = new JButton("Reset");
        reset.setBackground(Color.magenta);
        JButton exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        dikstra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dikstra.setBackground(Color.GREEN);
                breathFirst.setBackground(Color.LIGHT_GRAY);
                depthFirst.setBackground(Color.LIGHT_GRAY);
                diskstraSearch = true;
                breathSearch = false;
                depthSearch = false;
            }
        });
        breathFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dikstra.setBackground(Color.LIGHT_GRAY);
                breathFirst.setBackground(Color.GREEN);
                depthFirst.setBackground(Color.LIGHT_GRAY);
                diskstraSearch = false;
                breathSearch = true;
                depthSearch = false;
            }
        });
        depthFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dikstra.setBackground(Color.LIGHT_GRAY);
                breathFirst.setBackground(Color.LIGHT_GRAY);
                depthFirst.setBackground(Color.GREEN);
                diskstraSearch = false;
                breathSearch = false;
                depthSearch = true;
            }
        });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (JButton button : buttonsArr) {
                    button.setBackground(null);
                }
                start = false;
                end = false;
                dikstra.setBackground(Color.GREEN);
                breathFirst.setBackground(Color.LIGHT_GRAY);
                depthFirst.setBackground(Color.LIGHT_GRAY);
                diskstraSearch = true;
                breathSearch = false;
                depthSearch = false;
                gridSearch.resetVisited();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                frame2.dispose();
                System.exit(0);
            }
        });

        frame2.add(dikstra);
        frame2.add(breathFirst);
        frame2.add(depthFirst);
        frame2.add(reset);
        frame2.add(exit);
        frame2.setSize(1000,100);
        frame2.setVisible(true);
    }
    public static JButton[] getButtonArray(){
        return buttonsArr;
    }
}
