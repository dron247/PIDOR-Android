package com.applepride.pidor.base;

/**
 * Created by dron on 13.03.17.
 */

public interface InteractorListener<T> {
    void callback(T data, Throwable error);
}
