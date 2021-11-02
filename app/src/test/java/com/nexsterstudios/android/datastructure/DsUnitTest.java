package com.nexsterstudios.android.datastructure;

import static org.junit.Assert.assertEquals;

import com.nexsterstudios.android.datastructure.tree.Ds;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DsUnitTest {

    @Test
    public void isAnagramTest01() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram("knee", "keen");
        assertEquals(true, status);
    }

    @Test
    public void isAnagramTest02() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram("knee", "kenn");
        assertEquals(false, status);
    }

    @Test
    public void isAnagramTest03() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram("knee", null);
        assertEquals(false, status);
    }

    @Test
    public void isAnagramTest04() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram(null, null);
        assertEquals(false, status);
    }

    @Test
    public void isAnagramTest05() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram("", null);
        assertEquals(false, status);
    }

    @Test
    public void isAnagramTest06() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram("", "");
        assertEquals(false, status);
    }

    @Test
    public void findGroupOfAnagramTest01() {
        String[] data = {"knee", "abc", "silent", "bca", "keen", "Listen"};
        Ds ds = new Ds();
        int count = ds.findGroupOfAnagram(data);
        assertEquals(3, count);
    }

    @Test
    public void findGroupOfAnagramTest02() {
        String[] data = {"knee", "aba", "silent", "bca", "keen", "Listen"};
        Ds ds = new Ds();
        int count = ds.findGroupOfAnagram(data);
        assertEquals(2, count);
    }

    @Test
    public void findGroupOfAnagramTest03() {
//        String[] data = {"knee","aba","silent","bca","keen","Listen"};
        Ds ds = new Ds();
        int count = ds.findGroupOfAnagram(null);
        assertEquals(0, count);
    }

    @Test
    public void findGroupOfAnagramTest04() {
        String[] data = {};
        Ds ds = new Ds();
        int count = ds.findGroupOfAnagram(data);
        assertEquals(0, count);
    }

    @Test
    public void isAnagram2Test01() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram2("knee", "keen");
        assertEquals(true, status);
    }

    @Test
    public void isAnagram2Test02() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram2("knee", "kenn");
        assertEquals(false, status);
    }

    @Test
    public void isAnagra2mTest03() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram2("knee", null);
        assertEquals(false, status);
    }

    @Test
    public void isAnagram2Test04() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram2(null, null);
        assertEquals(false, status);
    }

    @Test
    public void isAnagram2Test05() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram2("", null);
        assertEquals(false, status);
    }

    @Test
    public void isAnagram2Test06() {
        Ds ds = new Ds();
        boolean status = ds.isAnagram2("", "");
        assertEquals(false, status);
    }
}