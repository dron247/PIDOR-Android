package com.applepride.pidor.modules.module2.decorator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.applepride.pidor.App;
import com.applepride.pidor.R;
import com.applepride.pidor.model.object.TodoItem;
import com.applepride.pidor.model.repository.IExampleRepository;
import com.applepride.pidor.model.repository.TodoRepository;
import com.applepride.pidor.modules.module2.interactor.AddTodoItemInteractor;
import com.applepride.pidor.modules.module2.interactor.IAddTodoItemInteractor;
import com.applepride.pidor.modules.module2.presenter.IModule2Presenter;
import com.applepride.pidor.modules.module2.presenter.Module2Presenter;
import com.applepride.pidor.modules.module2.router.IModule2Router;
import com.applepride.pidor.router.RouterProvider;

public class Module2Activity extends AppCompatActivity implements IModule2Decorator {
    IModule2Router router;
    IModule2Presenter presenter;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        App app = (App) getApplication();
        RouterProvider provider = app.getRouterProvider();
        try {
            router = provider.connect(Module2Activity.class, this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        IExampleRepository<TodoItem> repository = TodoRepository.instance(); // DO NOT DO THIS IN REAL CODE!!!!
        IAddTodoItemInteractor interactor = new AddTodoItemInteractor(repository);

        presenter = new Module2Presenter(interactor, router);
        presenter.bind(this);

        Button buttonAdd = (Button) findViewById(R.id.button_add);
        Button buttonCancel = (Button) findViewById(R.id.button_cancel);
        editText = (EditText) findViewById(R.id.edit_todo);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAddClick(editText.getText().toString());
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onCancelClick();
            }
        });

    }


    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
