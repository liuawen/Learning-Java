/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.lou.simhasher;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.lou.simhasher.seg.WordsSegment;
import com.lou.simhasher.util.DicReader;

/**
 * 关键词抽取类。消除停用词，并对词语进行tfidf权重计算
 * 
 * @author louxuezheng@hotmail.com
 */
public final class KeywordExtractor {
	private Map<String, Double> idfMap = new HashMap<String, Double>();
	private Set<String> stopWords = new HashSet<String>();
	private double idfAverage;
	private static KeywordExtractor instance = new KeywordExtractor();

	public static KeywordExtractor getInstance() {
		return instance;
	}

	/**
	 * 构造函数
	 * 
	 */
	private KeywordExtractor() {
		String stopwordPath = "dict/stop_words.utf8";
		String idfPath = "dict/idf.utf8";
		loadIdfDict(idfPath);
		loadStopWordDict(stopwordPath);
	}

	/**
	 * 抽取词，消除停用词，并对词语进行tfidf权重计算
	 * 
	 * @param str str
	 * @return
	 */
	public Map<String, Double> extract(String str) {
		List<String> words = WordsSegment.getCutWords(str);

		// 计算词频tf
		Map<String, Double> wordmap = new HashMap<String, Double>();
		for (String word : words) {
			if (!wordmap.containsKey(word)) {
				wordmap.put(word, 1.0);
			}else{
				wordmap.put(word, wordmap.get(word) + 1);
			}
		}
		
		
		// 删除停用词并计算权重
		Iterator<Entry<String, Double>> it = wordmap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Double> item = (Entry<String, Double>) it.next();
			String word = item.getKey();
			if (stopWords.contains(word)) {
				it.remove();
				continue;
			}

			// 计算权重tdf
			if (idfMap.containsKey(word)) {
				double idf = wordmap.get(word) * idfMap.get(word);
				wordmap.put(word, idf);
			} else {
				double idf = wordmap.get(word) * idfAverage;
				wordmap.put(word, idf);
			}
		}

		//for(String key:wordmap.keySet()){
		//	System.out.println(key+" : "+wordmap.get(key));
		//}
		
		return wordmap;
	}

	/**
	 * 加载idf语料词典
	 * 
	 * @param idfPath
	 */
	private void loadIdfDict(String idfPath) {
		BufferedReader bf = DicReader.getReader(idfPath);
		double idf = 0.0;
		double idfSum = 0.0;
		int lineno = 0;
		String[] arrStrings = null;
		String line = null;
		try {
			while ((line = bf.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				arrStrings = line.split(" ");
				if (arrStrings.length != 2) {
					continue;
				}
				idf = Double.valueOf(arrStrings[1]);
				idfMap.put(arrStrings[0], idf);
				idfSum += idf;
				lineno++;
			}
		} catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
		}

//		assert (lineno > 0);
		idfAverage = idfSum / lineno;
//		assert (idfAverage > 0.0);
	}

	/**
	 * 加载停用词
	 * 
	 * @param filePath
	 */
	private void loadStopWordDict(String filePath) {
		BufferedReader bf = DicReader.getReader(filePath);
		String line = null;
		try {
			while ((line = bf.readLine()) != null) {
				stopWords.add(line);
			}
		} catch (IOException e) {
            e.printStackTrace();
		}
	}

}
