package org.graypc;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by graypc on 12/2/16.
 */
public class PasswordKeeper extends JFrame implements WindowListener, ActionListener {
    private CredentialsTableModel mTableModel;
    private JTable mTable;
    private TableRowSorter<CredentialsTableModel> mTableSorter;

    public PasswordKeeper()
    {
        super("Password Keeper");
        mTableModel = new CredentialsTableModel();
        mTable = new JTable(mTableModel);
        mTableSorter = new TableRowSorter<CredentialsTableModel>(mTableModel);
        mTable.setRowSorter(mTableSorter);

        createAndShowGUI();
    }

    private void createAndShowGUI()
    {
        //Create and set up the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        getContentPane().add(mainPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JScrollPane scrollPane = new JScrollPane(mTable);
        mTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        mTable.setFillsViewportHeight(true);
        mainPanel.add(scrollPane);

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.X_AXIS));
        JButton addButton = new JButton("Add Below");
        JButton delButton = new JButton("Delete");
        controlsPanel.add(addButton);
        controlsPanel.add(delButton);
        mainPanel.add(controlsPanel);

        addButton.addActionListener(this);
        delButton.addActionListener(this);

        addButton.setName("addButton");
        delButton.setName("delButton");

        //Display the window.
        pack();
        addWindowListener(this);
    }

    public void windowOpened(WindowEvent windowEvent)
    {}

    public void windowClosing(WindowEvent windowEvent)
    {
        List<Credential> credentials = mTableModel.getCredentials();
        Credential c;

        for (int tableRow = 0; tableRow < credentials.size(); ++tableRow)
        {
            int modelRow = mTableSorter.convertRowIndexToModel(tableRow);

            c = credentials.get(modelRow);
            System.out.format("Name[%s]\n", c.getName());
        }
    }

    public void windowClosed(WindowEvent windowEvent)
    {}

    public void windowIconified(WindowEvent windowEvent)
    {}

    public void windowDeiconified(WindowEvent windowEvent)
    {}

    public void windowActivated(WindowEvent windowEvent)
    {}

    public void windowDeactivated(WindowEvent windowEvent)
    {}

    public void actionPerformed(ActionEvent actionEvent)
    {
        // Determine which button was clicked
        JButton button = (JButton)actionEvent.getSource();

        if (button.getName().equals("addButton"))
        {
            int selectedRow = mTable.getSelectedRow();
            mTableModel.insertRow(selectedRow);
        }
    }
}
