// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   InputMatrix.java


public class InputMatrix
{

    InputValue value[];
    int dimension;

    public InputMatrix(int i, int j)
    {
        value = new InputValue[i];
        dimension = j <= 0 || j >= 4 ? 3 : j;
        for(int k = 0; k < i; k++)
        {
            value[k] = new InputValue();
        }

    }

    public void setInputX(int ai[])
    {
        if(ai.length <= value.length)
        {
            for(int i = 0; i < ai.length; i++)
            {
                value[i].setX(ai[i]);
            }

        }
    }

    public void setInputY(int ai[])
    {
        if(ai.length <= value.length)
        {
            for(int i = 0; i < ai.length; i++)
            {
                value[i].setY(ai[i]);
            }

        }
    }

    public void setInputZ(int ai[])
    {
        if(ai.length <= value.length)
        {
            for(int i = 0; i < ai.length; i++)
            {
                value[i].setZ(ai[i]);
            }

        }
    }

    public void setInputValues(int ai[], int ai1[], int ai2[])
    {
        setInputX(ai);
        setInputY(ai1);
        setInputZ(ai2);
    }

    int getDimension()
    {
        return dimension;
    }

    InputValue[] getInputValues()
    {
        return value;
    }

    InputValue getRandomInput()
    {
        return value[(int)(Math.random() * (double)value.length)];
    }

    int size()
    {
        return value.length;
    }
}
