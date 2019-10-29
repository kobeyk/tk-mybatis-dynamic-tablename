package cn.bluethink.utils;
import java.util.*;

/**
 * <p>通用工具类</p>
 *
 * @Author Appleyk
 * @Blob https://blog.csdn.net/appleyk
 * @Date Created on 下午 3:29 2018-11-14
 * @Version V.1.0.1
 */
public class GxGeneralUtils {

    /**
     * 验证对象是否为空，空：返回空串，不空：返回对象的string类型
     * @param object
     * @return
     */
    public static String validStringValue(Object object) {
        return object == null ? "" : object.toString();
    }

    /**
     * 验证对象是否为整数
     * @param object
     * @return
     */
    public static int validIntValue(Object object) {
        return object == null ? 0 : Integer.valueOf(object.toString());
    }

    /**
     * 验证对象是否为long类型
     * @param object
     * @return
     */
    public static long validLongValue(Object object) {
        return object == null ? 0 : Long.valueOf(object.toString());
    }

    /**
     * 验证对象是否为空 ==> 本身空 或者 值为空
     * @param object 对象
     * @return boolean
     */
    public static boolean isNotEmpty(Object object){

        if(object == null){
            return false;
        }

        if (object instanceof Integer){
            return Integer.valueOf(object.toString()) > 0 ;
        }else if(object instanceof Long){
            return Long.valueOf(object.toString()) > 0 ;
        }else  if(object instanceof String){
            return ((String) object).trim().length() > 0;
        }else if(object instanceof StringBuffer){
            return ((StringBuffer) object).toString().trim().length() > 0;
        }else if(object instanceof Boolean){
            return Boolean.valueOf(object.toString());
        }else if(object instanceof List){
            return ((List<?>) object).size() > 0;
        }else if(object instanceof Set){
            return ((Set<?>) object).size() > 0;
        }else if(object instanceof Map){
            return ((Map<?, ?>) object).size() > 0;
        }else if(object instanceof Iterator){
            return ((Iterator<?>) object).hasNext();
        }else if(object.getClass().isArray()){
            return Arrays.asList(object).size() > 0;
        }

        return true;
    }


    /**
     * 验证对象是否为空 ==> 本身空 或者 值为空
     * @param object 对象
     * @return boolean
     */
    public static boolean isEmpty(Object object){

        if(object == null){
            return true;
        }

        if (object instanceof Integer){
            return Integer.valueOf(object.toString()) == 0 ;
        }else if(object instanceof Long){
            return Long.valueOf(object.toString()) == 0 ;
        }else  if(object instanceof String){
            return ((String) object).trim().length() == 0;
        }else if(object instanceof StringBuffer){
            return ((StringBuffer) object).toString().trim().length() == 0;
        }else if(object instanceof Boolean){
            return Boolean.valueOf(object.toString());
        }else if(object instanceof List){
            return ((List<?>) object).size() == 0;
        }else if(object instanceof Set){
            return ((Set<?>) object).size() == 0;
        }else if(object instanceof Map){
            return ((Map<?, ?>) object).size() == 0;
        }else if(object instanceof Iterator){
            return !((Iterator<?>) object).hasNext();
        }else if(object.getClass().isArray()){
            return Arrays.asList(object).size() == 0;
        }

        return false;
    }

    /**
     * set<Long>转list<Long>
     * @param sets set集合
     * @return List<Long>
     */
    public static List<Long> set2List(Set<Long> sets){

        List<Long> list = new ArrayList<>();
        if (sets != null && sets.size() > 0) {

            // 类型转换
            for (Object o : sets) {
                Long id = Long.valueOf(o.toString());
                list.add(id);
            }
            return  list;
        }else{
            return  null;
        }
    }

    public static List<String> set2ListStr(Set<?> set) {
        List<String> result = new ArrayList<>();
        try {
            if (set.size() > 0) {
                set.forEach(s -> result.add(s.toString()));
            }
        } catch (Exception ex) {
            System.err.println("HashSet转换失败");
        }
        return result;
    }

    public static Set<Long> list2Set(List<String> list) {
        Set<Long> result = new HashSet<>();
        try {
            if (list.size() > 0) {
                list.forEach(s -> result.add(Long.parseLong(s)));
            }
        } catch (Exception ex) {
            System.err.println("List转换失败");
        }
        return result;
    }

    /**
     * hashSet泛型转Set<Long>
     * @param sets set集合
     * @return Set<Long>
     */
    public static Set<Long> hashSetToSet(HashSet<?> sets){

        Set<Long> result = new HashSet<>();
        if (sets != null && sets.size() > 0) {
            // 类型转换
            for (Object o : sets) {
                Long id = Long.valueOf(o.toString());
                result.add(id);
            }
            return  result;
        }else{
            return  null;
        }
    }


    public static List<String> setToList(Set<?> set) {
        List<String> result = new ArrayList<>();
        try {
            if (set.size() > 0) {
                set.forEach(s -> result.add(s.toString()));
            }
        } catch (Exception ex) {
            System.err.println("HashSet转换失败");
        }
        return result;
    }

    public static List<String> listToList(List<?> list) {
        List<String> result = new ArrayList<>();
        try {
            if (list.size() > 0) {
                list.forEach(s -> result.add(s.toString()));
            }
        } catch (Exception ex) {
            System.err.println("List转换失败");
        }
        return result;
    }

    public static String listToString(List<String> list){
        if (list == null) {
            return null;
        }
        String result = "";
        try {
            if (list.size() <= 0){
                return result;
            }
            for (String s : list) {
                result += s + ";";
            }
            result = result.substring(0, result.length() - 1);
        }catch (Exception ex) {
            System.err.println("List转换失败");
        }
        return result;
    }

    public static List<String> StringTolist(String str){
        if (str == null || str.length() == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        try {
            String[] strs = str.substring(1,str.length()-1).replaceAll("\"", "").split(",");
            for (String result:strs){
                list.add(result);
            }
        }catch (Exception ex) {
            System.err.println("List转换失败");
        }
        return list;
    }

    public static void main(String[] args) {
        Integer a = null;
        System.out.println(isNotEmpty(a));

        String str = "[\"11\",\"222\"]";
        List<String> list = StringTolist(str);
        System.out.println();
    }

}
