/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstarcraft.ai.jsat.classifiers.neuralnetwork;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jstarcraft.ai.jsat.FixedProblems;
import com.jstarcraft.ai.jsat.classifiers.ClassificationDataSet;
import com.jstarcraft.ai.jsat.classifiers.DataPointPair;
import com.jstarcraft.ai.jsat.classifiers.neuralnetwork.Perceptron;
import com.jstarcraft.ai.jsat.utils.random.RandomUtil;

/**
 *
 * @author Edward Raff
 */
public class PerceptronTest {

    public PerceptronTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of train method, of class Perceptron.
     */
    @Test
    public void testTrainC_ClassificationDataSet_ExecutorService() {
        System.out.println("trainC");
        ClassificationDataSet train = FixedProblems.get2ClassLinear(200, RandomUtil.getRandom());

        Perceptron instance = new Perceptron();
        instance = instance.clone();
        instance.train(train, true);
        instance = instance.clone();

        ClassificationDataSet test = FixedProblems.get2ClassLinear(200, RandomUtil.getRandom());

        for (DataPointPair<Integer> dpp : test.getAsDPPList())
            assertEquals(dpp.getPair().longValue(), instance.classify(dpp.getDataPoint()).mostLikely());
    }

    /**
     * Test of train method, of class Perceptron.
     */
    @Test
    public void testTrainC_ClassificationDataSet() {
        System.out.println("trainC");
        ClassificationDataSet train = FixedProblems.get2ClassLinear(200, RandomUtil.getRandom());

        Perceptron instance = new Perceptron();
        instance = instance.clone();
        instance.train(train);
        instance = instance.clone();

        ClassificationDataSet test = FixedProblems.get2ClassLinear(200, RandomUtil.getRandom());

        for (DataPointPair<Integer> dpp : test.getAsDPPList())
            assertEquals(dpp.getPair().longValue(), instance.classify(dpp.getDataPoint()).mostLikely());
    }

}
