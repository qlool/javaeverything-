package com.qlool.java.base.event;

import java.util.EventObject;

/**
 * @Author: cxn
 * @Description: (事件.事件对象)
 * @Date: Created in 9:29 2018/5/11
 * @Modified by:
 */
public class MyEvent extends EventObject{

    private static final long serialVersionUID = 1L;

    private int sourceState;

    public MyEvent(Object source) {
        super(source);
        sourceState = ((Source) source).getFlag();
    }

    public int getSourceState() {
        return sourceState;
    }
}
