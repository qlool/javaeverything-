package com.qlool.java.base.event;

import java.util.EventListener;

/**
 * @Author: cxn
 * @Description: (事件.事件监听器)
 * @Date: Created in 17:24 2018/5/22
 * @Modified by:
 */
public class StateChangeListener implements EventListener {

    public void handleEvent(MyEvent event) {

        System.out.println("触发状态改变事件。。。");
        System.out.println("当前事件源状态为：" + event.getSourceState());
        System.out.println("。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
