package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testFound() {
        String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra", "selin", "sena", "yagmur", "ase", "sa"};
        String s = "sea";
        int integ = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        //ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        new App();
        assertSame(1, App.search(list, integ, s, strings));
    }

    public void testNotFound() {
        String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra", "selin", "sena", "yagmur", "ase", "sa"};
        String s = "telecom";
        int integ = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        new App();
        assertNotSame(7, App.search(list, integ, s, strings));
    }

    public void testEmptyArray() {
        String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra", "selin", "sena", "yagmur", "ase", "sa"};
        String s = "file";
        int integ = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        new App();
        assertFalse("it is TRUE", App.search(list, integ, s, strings)==9);
    }

    public void testNull() {
        String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra", "selin", "sena", "yagmur", "ase", "sa"};
        String s = "privacy";
        int integ = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        new App();
        assertNotNull("it is not NULL", App.search(list, integ, s, strings));
    }
    public void testWFormat() {
        String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra", "selin", "sena", "yagmur", "ase", "sa"};
        String s = "run";
        int integ = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        new App();
        assertFalse("I do not know why", App.search(list, integ, s, strings)==0);
    }

}
