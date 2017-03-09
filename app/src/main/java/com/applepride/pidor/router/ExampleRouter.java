package com.applepride.pidor.router;

import com.applepride.pidor.base.Router;

/**
 * Created by Андрей on 07.03.2017.
 */

public final class ExampleRouter implements Router {
    //блин, это не роутер, а кодинжектор получается :(


    //регистрируем активитю и пихаем резолвер и для какого класса его отдавать
    public <E extends BaseResolver> void register(Class<?> recipientClazz, E resolver) {
        //
    }

    //в роутируемом классе коннектимся к роутеру и получаем доступ к ручке, которую закинули при регистрации
    public <E extends BaseResolver> E connect(Class<?> clazz) {
        return null;
    }

    public void resolve(Class<?> clazz) {
        //
    }
}
