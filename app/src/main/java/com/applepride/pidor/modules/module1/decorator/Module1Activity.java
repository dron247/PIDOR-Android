package com.applepride.pidor.modules.module1.decorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.applepride.pidor.App;
import com.applepride.pidor.R;
import com.applepride.pidor.model.object.TodoItem;
import com.applepride.pidor.model.repository.IExampleRepository;
import com.applepride.pidor.model.repository.TodoRepository;
import com.applepride.pidor.modules.module1.interactor.ILoadTodoItemsInteractor;
import com.applepride.pidor.modules.module1.interactor.LoadTodoItemsInteractor;
import com.applepride.pidor.modules.module1.object.TodoListItem;
import com.applepride.pidor.modules.module1.presenter.IModule1Presenter;
import com.applepride.pidor.modules.module1.presenter.Module1Presenter;
import com.applepride.pidor.modules.module1.router.IModule1Router;
import com.applepride.pidor.router.RouterProvider;

import java.util.List;

public class Module1Activity extends AppCompatActivity implements IModule1Decorator {
    IModule1Router router;
    IModule1Presenter presenter;
    Button buttonDialog;
    Button buttonModule2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Build dependency objects
        // instantiate all the arch stuff, can be injected
        App app = (App) getApplication();
        final RouterProvider provider = app.getRouterProvider();
        try {
            router = provider.connect(Module1Activity.class, this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        IExampleRepository<TodoItem> repository = TodoRepository.instance(); // DO NOT DO THIS IN REAL CODE!!!!
        ILoadTodoItemsInteractor loadTodoItemsInteractor = new LoadTodoItemsInteractor(repository);
        presenter = new Module1Presenter(router, loadTodoItemsInteractor);
        presenter.bind(this);
        // end dependency building


        // initialize view
        buttonDialog = (Button) findViewById(R.id.button_dialog);
        buttonModule2 = (Button) findViewById(R.id.button_module2);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onShowExampleDialog();
            }
        });

        buttonModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNavigateAway();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.items_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // update data, it's just an illustration
        // consider subscription to model layer
        // messages inside presenter
        presenter.loadItems();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void setItems(List<TodoListItem> items) {
        // populate list
        recyclerView.setAdapter(null);
        recyclerView.setLayoutManager(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ExampleAdapter adapter = new ExampleAdapter(items);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new ExampleAdapter.ClickListener() {
            @Override
            public void onItemClick(TodoListItem item) {
                Toast.makeText(Module1Activity.this, item.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    static class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {
        List<TodoListItem> items;
        ClickListener clickListener;

        ExampleAdapter(List<TodoListItem> items) {
            this.items = items;
            setHasStableIds(true);
        }

        public void setOnClickListener(ClickListener listener) {
            clickListener = listener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_todo, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            TodoListItem item = getItem(position);
            holder.id = item.getId();
            holder.text.setText(item.getText());
            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.onItemClick(getItem(holder.id));
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        private TodoListItem getItem(int position) {
            return items.get(position);
        }

        interface ClickListener {
            void onItemClick(TodoListItem item);
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            int id;
            TextView text;
            View container;

            ViewHolder(View itemView) {
                super(itemView);
                container = itemView.findViewById(R.id.row_todo_container);
                text = (TextView) itemView.findViewById(R.id.row_todo_label);
            }
        }
    }
}
