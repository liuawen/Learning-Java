/**
 * Copyright (c)  2011-2020 Panguso, Inc.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of Panguso,
 * Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.lou.simhasher.seg;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 文档分词
 *
 * @author louxuezheng@hotmail.com
 */
public final class WordsSegment {

    private WordsSegment() {
    }

    /**
     * 分词
     *
     * @param str 字符串
     * @return
     */
    public static List<String> getCutWords(String str) {
        Analyzer analyzer = new IKAnalyzer();
        Reader r = new StringReader(str);
        List<String> list = new ArrayList<String>();
        try {
            TokenStream ts = analyzer.tokenStream("searchValue", r);

            ts.addAttribute(CharTermAttribute.class);
            ts.reset();

            while (ts.incrementToken()) {
                CharTermAttribute ta = ts.getAttribute(CharTermAttribute.class);
                String word = ta.toString();
                list.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        return list;
    }
}