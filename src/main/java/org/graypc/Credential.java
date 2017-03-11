package org.graypc;

/**
 * Created by graypc on 3/11/17.
 */
public class Credential
{
    public Credential()
    {
        mName = "";
        mUrl = "";
        mUserName = "";
        mPassword = "";
    }

    public Credential(String n, String u, String un, String p)
    {
        mName = n;
        mUrl = u;
        mUserName = un;
        mPassword = p;
    }

    public String getName()
    {
        return mName;
    }

    public String getUrl()
    {
        return mUrl;
    }

    public String getUserName()
    {
        return mUserName;
    }

    public String getPassword()
    {
        return mPassword;
    }

    private String mName;
    private String mUrl;
    private String mUserName;
    private String mPassword;
}
