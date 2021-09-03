package io.github.hooj0.reflection.dynamicproxy;

/**
 * 警察
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 11:51:29
 */
public class Police implements GatherInformation {

    private GatherInformation info;

    public void message(String msg) {
        info = new XiGui();
        info.message(msg);
    }

    public static void main(String[] args) {
        Police p = new Police();
        p.message("police 要情报！");
    }
}
