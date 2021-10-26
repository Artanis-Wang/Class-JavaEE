package server.demo.domain;

/**@author 王梓宇
 * @time 2021.10.18
 * 定义 消息体
 */
public class msg {
    public int code;
    public String m;
    public msg(int code,String m)
    {
        this.code = code;
        this.m = m;
    }
    public msg()
    {
        this.code = 0;
        this.m = "Exception";
    }
}
