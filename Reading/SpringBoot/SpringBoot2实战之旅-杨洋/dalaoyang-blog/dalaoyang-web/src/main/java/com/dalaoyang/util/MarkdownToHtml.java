package com.dalaoyang.util;


import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class MarkdownToHtml {

    public static String markDownToHtml(String makeDownStr) {
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        return pdp.markdownToHtml(makeDownStr);
    }
}
