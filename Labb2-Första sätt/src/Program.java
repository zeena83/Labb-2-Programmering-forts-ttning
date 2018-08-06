import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Program {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
        window.setTitle("Cache memory - 2^n");
        window.setSize(new Dimension(600, 300));
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(600, 100));
        final JTextField input = new JTextField("0");
        input.setPreferredSize(new Dimension(150,40));
        inputPanel.add(input, BorderLayout.EAST);
        
        //Result
        JPanel outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension (400, 150));
        final JLabel output = new JLabel("Result: ");
        output.setPreferredSize(new Dimension (300, 50));
        outputPanel.add(output, BorderLayout.EAST);

        //Compute 2^n knapp
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(600, 50));
        JButton computeButton = new JButton("Compute 2^n");
        computeButton.setPreferredSize(new Dimension (130, 40));

        //Clear memory knapp
        JPanel buttonPanel1 = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(600, 50));
        JButton clearmemoryButton = new JButton("Clear memory");
        clearmemoryButton.setPreferredSize(new Dimension (130, 40));
        
        //Quit knapp
        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension (130, 40));

        
        buttonPanel1.add(computeButton, BorderLayout.EAST);
        buttonPanel1.add(clearmemoryButton, BorderLayout.CENTER);
        buttonPanel1.add(quitButton, BorderLayout.WEST);

        window.add(inputPanel, BorderLayout.NORTH);
        window.add(outputPanel, BorderLayout.CENTER);
        window.add(buttonPanel1, BorderLayout.SOUTH);

        
        computeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                    output.setText("Result: "+Model.compute2Power(Integer.valueOf(input.getText()).intValue()));
                }
                
                catch(IllegalArgumentException e){
                    output.setText("input a positive number please");
                    return;
                }
            }

            
        });
        

        
        clearmemoryButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                output.setText("Memory cleared");
            }
        });
        

        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        
        
        window.setVisible(true);


	}

}
