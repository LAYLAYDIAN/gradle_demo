package com.gradle.api_server.utils;
import java.util.*;

/**
 * @Description: 字符串处理的公共类
 * @Author: Liu Guo Dian
 * @Date: 2020/7/14 19:26
 * @Version: 1.0
 */
public class StringUtils {
    /**
     * 将字符串的数据，转换成中文的大写货币值
     *
     * @param pValue
     * @return
     */
    public static String convertToBigMoney(String pValue) {
        double S = 0;

        try {
            S = Double.parseDouble(pValue);
        } catch (Exception e) {
        }

        S = S + 0.005; // 把它加0.005,为了预防浮点数的四舍五入造成的误差
        String Result = "", odxs, odxc, temp1, temp2;
        int integer, Point, ormb;
        odxs = "零壹贰叁肆伍陆柒捌玖";
        odxc = "分角圆拾佰仟万拾佰仟亿拾佰仟万拾佰仟亿拾佰仟";
        try {
            integer = (int) S; // 取得他的整数部分
            Point = (int) (100 * (S - (float) integer)); // 取得他的小数部分
            if (integer == 0) {
                Result = "零圆"; // 如果整数为0,则显示零圆
            }
            for (int i = 1; integer > 0; i++) {
                ormb = (integer % 10); // 取得他的个位
                temp1 = odxs.substring(ormb, ormb + 1);// 根据相应的值取得他的大写
                temp2 = odxc.substring(i + 1, i + 2); // 根据循环次数确定他的单位
                Result = temp1 + temp2 + Result;
                integer = integer / 10;
            }
            ormb = (Point / 10); // 取得角
            for (int i = 1; i > -1; i--) {
                temp1 = odxs.substring(ormb, ormb + 1);// 根据相应的值取得他的大写
                temp2 = odxc.substring(i, i + 1); // 根据循环次数确定他的单位
                Result = Result + temp1 + temp2;
                ormb = Point % 10; // 取得分
            }
            // System.out.print("Result frist: "+Result);
            Result = Result.replaceAll("零仟", "零");
            Result = Result.replaceAll("零佰", "零");
            Result = Result.replaceAll("零拾", "零");
            while (Result.indexOf("零零") > -1) {
                Result = Result.replaceAll("零零", "零");
            }
            Result = Result.replaceAll("零圆", "圆");
            Result = Result.replaceAll("零万", "万");
            if ("圆零角零分".equals(Result)) {
                Result = "零圆零角零分";
            }
            // System.out.print("Result second: "+Result);
        } catch (Exception se) {
            se.printStackTrace();
        }
        return Result;
    }

    /**
     * 将数字串的数据，转换成中文的大写货币值
     *
     * @param pValue
     * @return
     */
    public static String convertToBigMoney(double pValue) {
        double S = pValue;
        S = S + 0.005; // 把它加0.005,为了预防浮点数的四舍五入造成的误差
        String Result = "", odxs, odxc, temp1, temp2;
        int integer, Point, ormb;
        odxs = "零壹贰叁肆伍陆柒捌玖";
        odxc = "分角圆拾佰仟万拾佰仟亿拾佰仟万拾佰仟亿拾佰仟";
        try {
            integer = (int) S; // 取得他的整数部分
            Point = (int) (100 * (S - (float) integer)); // 取得他的小数部分
            if (integer == 0) {
                Result = "零圆"; // 如果整数为0,则显示零圆
            }
            for (int i = 1; integer > 0; i++) {
                ormb = (integer % 10); // 取得他的个位
                temp1 = odxs.substring(ormb, ormb + 1);// 根据相应的值取得他的大写
                temp2 = odxc.substring(i + 1, i + 2); // 根据循环次数确定他的单位
                Result = temp1 + temp2 + Result;
                integer = integer / 10;
            }
            ormb = (Point / 10); // 取得角
            for (int i = 1; i > -1; i--) {
                temp1 = odxs.substring(ormb, ormb + 1);// 根据相应的值取得他的大写
                temp2 = odxc.substring(i, i + 1); // 根据循环次数确定他的单位
                Result = Result + temp1 + temp2;
                ormb = Point % 10; // 取得分
            }
            // System.out.print("Result frist: "+Result);
            Result = Result.replaceAll("零仟", "零");
            Result = Result.replaceAll("零佰", "零");
            Result = Result.replaceAll("零拾", "零");
            while (Result.indexOf("零零") > -1) {
                Result = Result.replaceAll("零零", "零");
            }
            Result = Result.replaceAll("零圆", "圆");
            Result = Result.replaceAll("零万", "万");
            if ("圆零角零分".equals(Result)) {
                Result = "零圆零角零分";
            }
            // System.out.print("Result second: "+Result);

        } catch (Exception se) {
            se.printStackTrace();
        }
        return Result;
    }

    public static final String[] split(String line, String separator) {
        LinkedList list = new LinkedList();
        if (line != null) {
            int start = 0;
            int end = 0;
            int separatorLen = separator.length();
            while ((end = line.indexOf(separator, start)) >= 0) {
                list.add(line.substring(start, end));
                start = end + separatorLen;
            }
            if (start < line.length()) {
                list.add(line.substring(start, line.length()));
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static final String[] splitWithoutSpace(String line, String separator) {
        LinkedList list = new LinkedList();
        if (line != null) {
            int start = 0;
            int end = 0;
            int separatorLen = separator.length();
            while ((end = line.indexOf(separator, start)) >= 0) {
                String str = line.substring(start, end).trim();
                if (str != null && !"".equals(str)) {
                    list.add(str);
                }
                start = end + separatorLen;
            }
            if (start < line.length()) {
                String str = line.substring(start, line.length()).trim();
                if (str != null && !"".equals(str)) {
                    list.add(str);
                }
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static final String replaceAll(String line, String str1, String str2) {
        String newStr = "";
        boolean start = line.startsWith(str1);
        boolean end = line.endsWith(str1);
        String[] strs = split(line, str1);
        if (strs != null && strs.length > 0) {
            if (start) {
                newStr = newStr + str2;
            }
            for (int i = 0; i < strs.length; i++) {

                newStr = newStr + strs[i];

                if (i != strs.length - 1 || end) {

                    newStr = newStr + str2;
                }

            }

        } else {
            newStr = line;
        }
        return newStr;

    }

    public static String join(Iterator iterator, String separator) throws Exception {
        if (iterator == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(256);
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj != null) {
                buf.append("'" + obj + "'");
            }
            if (iterator.hasNext()) {
                buf.append(separator);
            }
        }
        return buf.toString();
    }

    /**
     * 把字符转换为钱数0.00的格式
     *
     *
     * @return
     */
    public static String formatToMoney(String str) {
        int place = 0;
        int len = 0;
        if (str == null || "".equals(str)) {
            return "0.00";
        }
        place = str.indexOf(".");
        if (place == -1) {
            return str = str + ".00";
        }
        len = str.length();
        if ((len - place) == 2) {
            str = str + "0";
        } else if ((len - place) == 1) {
            str = str + "00";
        } else {
            str = str.substring(0, place + 3);
        }
        return str;
    }

    public static HashMap mapKeyToLower(Map map) {
        HashMap newMap = new HashMap();
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        for (; iterator.hasNext();) {
            Object obj = iterator.next();
            if (obj instanceof String) {
                String objStr = (String) obj;
                newMap.put(objStr.toLowerCase(), map.get(obj));
            } else {
                newMap.put(obj, map.get(obj));
            }
        }
        return newMap;
    }

    public static HashMap mapKeyToUpper(Map map) {
        HashMap newMap = new HashMap();
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        for (; iterator.hasNext();) {
            Object obj = iterator.next();
            if (obj instanceof String) {
                String objStr = (String) obj;
                newMap.put(objStr.toUpperCase(), map.get(obj));
            } else {
                newMap.put(obj, map.get(obj));
            }
        }
        return newMap;
    }

    /**
     * String字符转MAP
     *
     * @param mapText
     * @return
     */
    public static Map<String, Object> stringToMap(String mapText) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (org.apache.commons.lang.StringUtils.isEmpty(mapText)) {
            return map;
        }
        mapText = mapText.trim();
        if (mapText.indexOf("{") == 0) {
            mapText = mapText.substring(1, mapText.length());
        }
        if (mapText.indexOf("}") == mapText.length() - 1) {
            mapText = mapText.substring(0, mapText.length() - 1);
        }
        String[] text = mapText.split(","); // 转换为数组
        for (String str : text) {
            String[] keyText = str.split("="); // 转换key与value的数组
            if (keyText.length < 1) {
                continue;
            }
            String key = keyText[0] == null ? "" : keyText[0].trim(); // key
            if (org.apache.commons.lang.StringUtils.isEmpty(key)) {
                continue;
            }
            String value = keyText[1] == null ? "" : keyText[1].trim(); // value
            map.put(key, value);
        }
        return map;
    }

    public static boolean isEmpty(String obj) {
        return ("".equals(obj) || null == obj);
    }

    public static boolean isNotEmpty(String string) {
        return string != null && string.length() > 0;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static String getStrValue(Map map, String key) {
        if (map == null || map.isEmpty() || StringUtils.isBlank(key)) {
            return "";
        }
        Object t = map.get(key);
        if (t != null) {
            return t.toString();
        } else {
            for (Object o : map.keySet()) {
                String name = (String) o;
                if (name.toLowerCase().equals(key.toLowerCase())) {
                    Object value = map.get(o);
                    if (value == null) {
                        return "";
                    }
                    return value.toString();
                }
            }
        }

        return "";
    }

    public static String getParmByIndex(String srcStr, int index, String mark)
    {
        String destStr = "";
        String strTemp;
        int startPos = 0, endPos = 0;
        int pos;
        if (mark.length() <= 0) {
            return destStr;
        }
        for (int i = 1; i < index; i++)
        {
            if ((pos = srcStr.indexOf(mark, startPos)) < 0)
            {
                return destStr;
            }
            startPos = pos + mark.length();
            if (startPos >= srcStr.length()) {
                return destStr;
            }
        }

        endPos = srcStr.indexOf(mark, startPos);
        if (endPos < 0) {
            endPos = srcStr.length();
        }

        destStr = srcStr.substring(startPos, endPos);
        return destStr;
    }

    public static String defaultIfEmpty(String str, String defaultStr) {
        return StringUtils.isEmpty(str) ? defaultStr : str;
    }

}
