import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
public class LightRow implements ActionListener{
    // instance variables 

    // get user input
    String getCol = JOptionPane.showInputDialog("Enter number of buttons:");
    // convert input ot integer value
    int col = Integer.parseInt(getCol);
    JFrame window = new JFrame();
    Container contentPane = new Container();
    // make array of type JButtons size of user input
    JButton[] buttons = new JButton[col];
    // array of color choices
    Color[] choices = {Color.pink, Color.white};


    // MAIN
    public static void main(String[] args){
        new LightRow();
    }

    public LightRow(){
        // make window
        window.setVisible(true);
        window.setSize(400,200);
        window.setTitle("LightRow");
        // make content pane 
        contentPane = window.getContentPane();
        contentPane.setLayout(new GridLayout(1,col));
        // make buttons with action listeners
        for ( int i = 0; i < col ;i++){
            JButton button = new JButton();
            contentPane.add(button);
            buttons[i] = button;
            buttons[i].addActionListener(this);
            buttons[i].setBackground(choices[(int)(Math.random()*2)]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event){
        // allows program to find which button recieved action
        JButton source = (JButton) event.getSource();

        for ( int i = 0; i < col; i++){
            // if first button is pushed, invert first and second buttons
            if ( source == buttons[i] ){
                if ( i == 0){
                    buttons[0].setBackground(invertColor(buttons[0].getBackground()));
                    buttons[1].setBackground(invertColor(buttons[1].getBackground()));;
                }// if last button is pushed, invert last and second to last button
                else if ( i == col - 1){
                    buttons[col - 1].setBackground(invertColor(buttons[col-1].getBackground()));
                    buttons[col - 2].setBackground(invertColor(buttons[col-2].getBackground()));
                }// invert ith button and adjacent buttons
                else{
                buttons[i].setBackground(invertColor(buttons[i].getBackground()));
                buttons[i+1].setBackground(invertColor(buttons[i+1].getBackground()));
                buttons[i-1].setBackground(invertColor(buttons[i-1].getBackground()));
                }
            }
        }

    }
    // METHOD TO INVERT COLORS
    public Color invertColor(Color oldColor){
        if ( oldColor != choices[1]){
        oldColor = choices[1];
        return oldColor;
        }
        else oldColor = choices[0];
        return oldColor;
    }
}