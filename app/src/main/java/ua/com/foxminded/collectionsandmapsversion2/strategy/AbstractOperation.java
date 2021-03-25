package ua.com.foxminded.collectionsandmapsversion2.strategy;

import android.os.Handler;
import android.os.Message;

abstract public class AbstractOperation<T> implements Runnable{
    protected T t;
    protected int dataStructureType;
    protected int id;
    protected Handler handler;

    public AbstractOperation(T t, int dataStructureType, int id) {
        this.t = t;
        this.dataStructureType = dataStructureType;
        this.id = id;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        int start = (int) System.currentTimeMillis();
        operation(t);
        int time = (int) System.currentTimeMillis() - start;
        Message msg = new Message();
        msg.what = dataStructureType;
        msg.arg1 = id;
        msg.arg2 = time;
        handler.sendMessage(msg);
    }

    protected abstract void operation(T dataStructure);
}

