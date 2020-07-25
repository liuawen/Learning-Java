package com.springboot.util;

import org.pegdown.PegDownProcessor;

public class MarkdownToHtml {

    public static String markDownToHtml(String makeDownStr) {
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        return pdp.markdownToHtml(makeDownStr);
    }
}
