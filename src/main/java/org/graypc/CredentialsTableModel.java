package org.graypc;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graypc on 3/11/17.
 */
public class CredentialsTableModel extends AbstractTableModel
{
    private String[] mColumnNames = {"System", "URL", "User name", "Password"};
    private List<Credential> mCredentials;

    public CredentialsTableModel()
    {
        super();
        mCredentials = new ArrayList<Credential>();
        Credential[] creds = new Credential[]{
                new Credential("Google", "google.com", "pete", "1234"),
                new Credential("USAA", "usaa.com", "pete", "456"),
                new Credential("Hertz", "hertz.com", "croniker_delta", "456"),
                new Credential("UnitedAirlines", "ual.com", "croniker", "456")
        };

        for (int ii = 0; ii < creds.length; ++ii)
            mCredentials.add(creds[ii]);
    }

    public void insertRow(int rowAbove)
    {
        // Adds a row below 'rowAbove'
        // If -1 then no row is selected to the bottom

        Credential c = new Credential();

        if (rowAbove == -1)
            mCredentials.add(c);
        else
            mCredentials.add(rowAbove - 1, c);

        fireTableDataChanged();
    }

    public List<Credential> getCredentials()
    {
        return mCredentials;
    }

    public int getRowCount()
    {
        if (mCredentials == null)
            return 0;

        return mCredentials.size();
    }

    public int getColumnCount()
    {
        return mColumnNames.length;
    }

    public String getColumnName(int col)
    {
        return mColumnNames[col];
    }

    public Object getValueAt(int row, int col)
    {
        if (mCredentials == null)
            return null;

        Credential c = mCredentials.get(row);
        switch (col)
        {
            case 0:
                return c.getName();

            case 1:
                return c.getUrl();

            case 2:
                return c.getUserName();

            case 3:
                return c.getPassword();
        }

        return null;
    }

    public Class getColumnClass(int c)
    {
        return String.class;
    }
}
