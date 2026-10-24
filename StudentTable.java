package FifthProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentTable extends JFrame implements ActionListener {
    private Container c;
    private JLabel titlelable,fnlable,lnlable,phonelable,gpalable;
    private JTextField fntf,lntf,phonetf,gpatf;
    private JButton addbutton,updatebutton,deletebutton,clearbutton;
    private Font f;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;


    private String[] columns = {"First name","Last name","phone number","CGPA"};
    private String[] rows = new String[4];

    StudentTable(){
        initComponents();
    }

    public void initComponents(){
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        f = new Font("Arial",Font.BOLD,18);

        titlelable = new JLabel("Student Registration");
        titlelable.setFont(f);
        titlelable.setBounds(140,10,250,50);
        c.add(titlelable);

        fnlable = new JLabel("First Name  ");
        fnlable.setBounds(10,80,140,30);
        fnlable.setFont(f);
        c.add(fnlable);

        fntf = new JTextField();
        fntf.setBounds(110,80,200,30);
        fntf.setFont(f);
        c.add(fntf);

        addbutton = new JButton("Add");
        addbutton.setBounds(400,80,100,30);
        addbutton.setFont(f);
        c.add(addbutton);

        lnlable = new JLabel("Last Name  ");
        lnlable.setBounds(10,130,150,30);
        lnlable.setFont(f);
        c.add(lnlable);

        lntf = new JTextField();
        lntf.setBounds(110,130,200,30);
        lntf.setFont(f);
        c.add(lntf);

        updatebutton = new JButton("Update");
        updatebutton.setBounds(400,130,100,30);
        updatebutton.setFont(f);
        c.add(updatebutton);

        phonelable = new JLabel("Phone ");
        phonelable.setBounds(10,180,150,30);
        phonelable.setFont(f);
        c.add(phonelable);

        phonetf = new JTextField();
        phonetf.setBounds(110,180,200,30);
        phonetf.setFont(f);
        c.add(phonetf);

        deletebutton = new JButton("Delete");
        deletebutton.setBounds(400,180,100,30);
        deletebutton.setFont(f);
        c.add(deletebutton);

        gpalable = new JLabel("CGPA ");
        gpalable.setBounds(10,230,200,30);
        gpalable.setFont(f);
        c.add(gpalable);

        gpatf = new JTextField();
        gpatf.setBounds(110,230,200,30);
        gpatf.setFont(f);
        c.add(gpatf);

        clearbutton = new JButton("Clear ");
        clearbutton.setBounds(400,230,100,30);
        clearbutton.setFont(f);
        c.add(clearbutton);

        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(f);
        table.setSelectionBackground(Color.cyan);
        table.setBackground(Color.GRAY);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10,360,740,265);
        c.add(scroll);

        addbutton.addActionListener(this);
        clearbutton.addActionListener(this);
        deletebutton.addActionListener(this);
        updatebutton.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int numberofRow = table.getSelectedRow();

                String f_name = model.getValueAt(numberofRow,0).toString();
                String l_name = model.getValueAt(numberofRow,1).toString();
                String gpa = model.getValueAt(numberofRow,3).toString();
                String phone = model.getValueAt(numberofRow,2).toString();

                fntf.setText(f_name);
                lntf.setText(l_name);
                phonetf.setText(phone);
                gpatf.setText(gpa);
            }
        });



    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addbutton){
            rows[0] = fntf.getText();
            rows[1] = lntf.getText();
            rows[2] = phonetf.getText();
            rows[3] = gpatf.getText();
            model.addRow(rows);

        }


        else if(e.getSource()==clearbutton){
            fntf.setText("");
            lntf.setText("");
            phonetf.setText("");
            gpatf.setText("");


        }
        else if(e.getSource()==deletebutton){
           int numberofRows = table.getSelectedRow();
           if(numberofRows>=0){
               model.removeRow(numberofRows);
           }
           else {
               JOptionPane.showMessageDialog(null,"No row has been selected or no row exits");
           }
        }
        else if(e.getSource()==updatebutton){
            int numberofRows = table.getSelectedRow();

            String f_name = fntf.getText();
            String l_name = lntf.getText();
            String phone = phonetf.getText();
            String gpa = gpatf.getText();

            model.setValueAt(f_name,numberofRows,0);
            model.setValueAt(l_name,numberofRows,1);
            model.setValueAt(phone,numberofRows,2);
            model.setValueAt(gpa,numberofRows,3);
        }


    }

    static void main() {
        StudentTable frame = new StudentTable();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780,690);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Student Table");

    }


}
