package net.xiuc.design.singleton;

import com.google.common.collect.Sets;

import java.util.Set;

public class SingletonExample1TestThread implements Runnable {
    final Set<SingletonExample1> instanceList = Sets.newHashSet();

    @Override
    public void run() {
        instanceList.add(SingletonExample1.getInstance());
    }
}