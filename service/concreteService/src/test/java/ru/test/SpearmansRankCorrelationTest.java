package ru.test;


import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by SKuptsov on 08.10.2015.
 */
public class SpearmansRankCorrelationTest{

    @Test
    public void testDifferentSizesCorrelationSameLine(){

        int size = 100000;
        int coef = 1000;
        double[] xArray = new double[size];
        double[] yArray = new double[size];

        Random random = new Random();
        for(int i = 0; i<size;i++ )
        {
            xArray[i] = random.nextDouble();
            yArray[i] =  xArray[i]*coef;
        }

        double correlation = new SpearmansCorrelation().correlation(xArray, yArray);

        Assert.assertEquals(correlation, 1.0, 0.0);
    }

    @Test
    public void testDifferentSizesCorrelationDiffLine(){

        int size = 100000;
        int coef = 1000;
        double[] xArray = new double[size];
        double[] yArray = new double[size];

        Random random = new Random();
        for(int i = 0; i<size;i++ )
        {
            xArray[i] = random.nextDouble();
            yArray[i] =  xArray[i]*coef*random.nextInt();
        }

        double correlation = new SpearmansCorrelation().correlation(xArray, yArray);

        Assert.assertNotEquals(correlation, 1.0, 0.0);
        System.out.println(correlation*100+"%");
    }


    @Test
    /**
     * Выборки разного кол-ва точек
     */
    public void testDifferentNumberOfPointsCorrelationDiffLine(){

        int size1 = 100000;
        int size2 = 100;
        double[] xArray = new double[size1];
        double[] yArray = new double[size2];

        Random random = new Random();
        for(int i = 0; i<size1;i++ )
        {
            xArray[i] = random.nextDouble();
        }
        for(int i = 0; i<size2;i++ )
        {
            yArray[i] = random.nextDouble();
        }


    }

}
