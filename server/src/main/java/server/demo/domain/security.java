package server.demo.domain;

/**@author 王梓宇
 * @time 2021.10.18
 * 用于加密的工具类
 */
public class security {
    public static String encrypt(String target)
    {
        StringBuilder str = new StringBuilder(target);
        return str.reverse().substring(0);
    }
    public static String decrypt(String target)
    {
        StringBuilder str = new StringBuilder(target);
        return str.reverse().substring(0);
    }
}
