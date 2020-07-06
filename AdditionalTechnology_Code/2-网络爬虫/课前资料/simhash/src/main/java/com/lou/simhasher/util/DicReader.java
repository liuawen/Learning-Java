package com.lou.simhasher.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 文档读入工具
 *
 * @author louxuezheng@hotmail.com
 */
public final class DicReader {

    private DicReader() {
    }

    /**
     * 返回BufferedReader
     *
     * @param name 文件名
     * @return
     */
    public static BufferedReader getReader(String name) {
        InputStream in = DicReader.class.getResourceAsStream("/" + name);
        try {
            return new BufferedReader(new InputStreamReader(in, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回InputStream
     *
     * @param name 文件名
     * @return
     */
    public static InputStream getInputStream(String name) {
        InputStream in = DicReader.class.getResourceAsStream("/" + name);
        return in;
    }
}
