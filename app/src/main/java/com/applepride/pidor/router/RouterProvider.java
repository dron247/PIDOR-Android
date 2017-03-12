package com.applepride.pidor.router;

import android.content.Context;

import com.applepride.pidor.base.IRouter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Андрей on 07.03.2017.
 */

public final class RouterProvider {
    Map<Class<?>, Class<?>> registry = new HashMap<>();

    private RouterProvider() {
    }

    public static RouterProvider create() {
        return new RouterProvider();
    }


    //регистрируем активитю и пихаем резолвер и для какого класса его отдавать
    public <E extends IRouter> void register(Class<?> recipientClazz, Class<E> routerClazz) {
        registry.put(recipientClazz, routerClazz);
    }

    //в роутируемом классе коннектимся к роутеру и получаем доступ к ручке, которую закинули при регистрации
    public <E extends IRouter> E connect(Class<?> clazz, Context context) throws InstantiationException {
        Class<?> instanceClass = registry.get(clazz);
        E instance;
        try {
            instance = (E) instanceClass.newInstance();
            instance.setContext(context);
        } catch (InstantiationException ie) {
            throw ie;
        } catch (IllegalAccessException iae) {
            return null;
        }
        return instance;
    }

}
