package ru.samsung.itschool.book;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.util.Random;

import static org.junit.Assert.*;
import static org.robolectric.shadows.ShadowInstrumentation.getInstrumentation;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    ActivityController controller;
    public static final String FOUR = "4.0";
    public static final String TWO = "2.0";
    private MainActivity activity;
    static StringBuffer sb;
    static int salt;

    @BeforeClass
    public static void report() {
        salt = new Random(System.currentTimeMillis()).nextInt(999);
        sb = new StringBuffer();
        sb.append(String.format("%03d", salt));
    }

    @Before
    public void setup() {
        controller = Robolectric.buildActivity(MainActivity.class);
        activity = (MainActivity) controller.create().get();
    }

    @Test
    public void test1() throws Exception {
        try {
            Button bt1 = (Button) activity.findViewById(R.id.btn_plus);
            Assert.assertNotNull(bt1);
            Button bt2 = (Button) activity.findViewById(R.id.btn_minus);
            Assert.assertNotNull(bt2);
            Button bt3 = (Button) activity.findViewById(R.id.btn_mult);
            Assert.assertNotNull(bt3);
            Button bt4 = (Button) activity.findViewById(R.id.btn_div);
            Assert.assertNotNull(bt4);
            EditText et_a = (EditText) activity.findViewById(R.id.et_a);
            Assert.assertNotNull(et_a);
            EditText et_b = (EditText) activity.findViewById(R.id.et_b);
            Assert.assertNotNull(et_b);
            TextView tv = (TextView) activity.findViewById(R.id.tv_result);
            Assert.assertNotNull(tv);
            et_a.setText(FOUR);
            et_b.setText(TWO);
            bt1.performClick();
            double r = Double.valueOf(tv.getText().toString());
            org.junit.Assert.assertEquals( 6,r, 0.001);
            bt2.performClick();
            r = Double.valueOf(tv.getText().toString());
            org.junit.Assert.assertEquals( 2, r,0.001);
            bt3.performClick();
            r = Double.valueOf(tv.getText().toString());
            org.junit.Assert.assertEquals( 8, r,0.001);
            bt4.performClick();
            r = Double.valueOf(tv.getText().toString());
            org.junit.Assert.assertEquals( 2, r,0.001);
            sb.append(",OK");
        } catch (Throwable t) {
        }
    }

    @Test
    public void test2() throws Exception {
        try {
        TextView tv = (TextView) activity.findViewById(R.id.tv_result);
        Assert.assertNotNull(tv);
        tv.setText(TWO);
        Bundle bundle = new Bundle();
        controller.saveInstanceState(bundle).pause().stop().destroy();
        controller = Robolectric.buildActivity(MainActivity.class)
                .create(bundle).start().restoreInstanceState(bundle)
                .resume().visible();
        activity = (MainActivity) controller.get();
        tv = (TextView) activity.findViewById(R.id.tv_result);
        Assert.assertNotNull(tv);
        org.junit.Assert.assertEquals(TWO, tv.getText().toString() );
        sb.append(",OK");
        } catch (Throwable t){}
    }


    @AfterClass
    public static void printResult() {
        System.err.println("\n\n=============================\nВАШ РЕЗУЛЬТАТ: " + sb.toString().hashCode() + "" + salt + "\n=============================\n");

    }

}