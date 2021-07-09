package pers.zpw.util;

import java.util.List;

/**
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-07-09 15:54
 */
public class ArrayUtil {

    public static <E> String toString(List<E> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (E e : list) {
            sb.append(String.valueOf(e)).append(" ");
        }
        return sb.toString();
    }
}
