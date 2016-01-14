package com.hanyx.hjoyblog.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.markdown4j.Markdown4jProcessor;

/**
 * @desc: Markdown的解析器
 * @author 韩元旭
 */
public final class MarkdownUtil {

	private MarkdownUtil() {}
	
	private final static Markdown4jProcessor parser;
	private final static Log log = LogFactory.getLog(MarkdownUtil.class);
	
	static {
		parser = new Markdown4jProcessor();
	}
	
	/**
	 * @desc: 将Markdown转为HTML
	 * @author: 韩元旭
	 * @param markdown
	 * @return
	 * @date  : 2016年1月14日
	 */
	public static String parse(String markdown) {
		if (StringUtil.isRealEmpty(markdown)) {
			return StringUtil.EMPTY_STR;
		}
		try {
			return parser.process(markdown);
		} catch (IOException e) {
			log.error("Markdown解析失败，内容：\n" + markdown,e);
			return StringUtil.EMPTY_STR;
		}
	}
}
