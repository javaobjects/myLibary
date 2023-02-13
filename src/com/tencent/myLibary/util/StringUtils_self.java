package com.tencent.myLibary.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils_self {

	/**
	 * <p>Title: isSpecialChar</p>
	 * <p>
	 *    Description:判断是否包含特殊字符 若包含则返回 true 
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param str
	 * @return
	 * @author xianxian
	 * @date 2023年2月13日下午2:42:52
	 * @version 1.0
	 */
	public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
	
	/**
	 * <p>Title: isChineseChar</p>
	 * <p>
	 *    Description:判断是否包含汉字
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param str
	 * @return
	 * @author xianxian
	 * @date 2023年2月13日下午2:49:55
	 * @version 1.0
	 */
	public static boolean isChineseChar(String str){
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}
	
	/**
	 * <p>Title: isNull</p>
	 * <p>
	 *    Description:字符串是否为空 true 表示为空
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param str
	 * @return
	 * @author xianxian
	 * @date 2023年2月13日下午2:56:24
	 * @version 1.0
	 */
	public static boolean isNull(String str) {
		if(str == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * <p>Title: firstWordIsLetter</p>
	 * <p>
	 *    Description:首字符是否为字母
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param str
	 * @return
	 * @author xianxian
	 * @date 2023年2月13日下午3:08:25
	 * @version 1.0
	 */
	public static boolean firstWordIsLetter(String str) {
		if(Character.isAlphabetic(str.indexOf(0))) {
			return true;
		}else {
			return false;
		}
	}
}
