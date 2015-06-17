package com.onlinedating.model;

import java.util.List;

/**
 * Created by Кирилл on 17.06.15.
 */
public class checkCompatibility {
    private int valueWoman = 0;
    private int valueMan = 0;
    private int persent = 0;
    private int[] a = new int[12];
    private String pathToConfigFile;
    public void Check(int Priority,String value)
    {
        readConfFile rCF = new readConfFile();
        a = rCF.getParametrs();
        if(value != "") {
            if ((Priority == 1) && (value == "\n" +  "I'll do it (easily)")) {
                valueWoman += a[0];
                valueMan += a[1];
            }
            if ((Priority == 1) && (value == "I'll do it (heavily)")) {
                valueWoman += a[2];
                valueMan += a[3];
            }
            if ((Priority == 1) && (value == "I will not do")) {
                valueWoman += a[4];
                valueMan += a[5];
            }

            if ((Priority == 0) && (value == "I'll do it (easily)")) {
                valueWoman += a[6];
                valueMan += a[7];
            }
            if ((Priority == 0) && (value == "I'll do it (heavily)"))
            {
                valueWoman += a[8];
                valueMan += a[9];
            }
            if ((Priority == 0) && (value == "I will not do")) {
                valueWoman += a[10];
                valueMan += a[11];
            }
        }
        else
            persent -= 1;
    }

    public int[] chechSum(List<Integer> values)
    {
        int[] maxMark = new int[2];
        int maxMan = 0;
        int maxWoman = 0;
        for (int i=0; i<6;i++)
        {
            if(i%2 == 1) {
                if (a[i] > maxMan)
                    maxMan = a[i];
            }
            else
            if (a[i] > maxWoman)
                maxWoman = a[i];
        }
        //   ab[0] =  maxWoman;
        //  ab[1] = maxMan;
        int maxMan2 = 0;
        int maxWoman2 = 0;
        for (int i = 6; i< 12;i++)
        {
            if(i%2 == 1) {
                if (a[i] > maxMan2)
                    maxMan2 = a[i];
            }
            else
            if (a[i] > maxWoman2)
                maxWoman2 = a[i];
        }
        for(int q = 0;q<values.size();q++) {
            if(values.get(q) == 1)
            {
                maxMark [1] += maxMan;
                maxMark [0] += maxWoman;
            }
            if (values.get(q) == 0)
            {
                maxMark [1] += maxMan2;
                maxMark [0] += maxWoman2;
            }
        }
        //ab[0] = maxWoman + maxWoman2;
        //ab[1] = maxMan + maxMan2;
        return maxMark ;

    }
    public int getValueWoman()
    {
        return valueWoman;
    }
    public int getValueMan()
    {
        return valueMan;
    }
    public int getPersent()
    {
        return persent;
    }


}
