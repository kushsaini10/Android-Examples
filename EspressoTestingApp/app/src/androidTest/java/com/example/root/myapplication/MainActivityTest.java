package com.example.root.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 18/7/17.
 */
public class MainActivityTest {
    @Test
    public void add() throws Exception {
        int c = 7;
        assertEquals(3,MainActivity.add(1,2));
    }

    @Test
    public void onCreate() throws Exception {

    }

}