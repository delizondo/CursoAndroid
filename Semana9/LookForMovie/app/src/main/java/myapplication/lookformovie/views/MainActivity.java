package myapplication.lookformovie.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import myapplication.lookformovie.R;
import myapplication.lookformovie.databinding.ActivityMainBinding;
import myapplication.lookformovie.viewModel.SearchViewModel;
import myapplication.lookformovie.views.adapter.MarginDecoration;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binder.recyclerView.addItemDecoration(new MarginDecoration(this));
        binder.recyclerView.setHasFixedSize(true);
        binder.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binder.setSearch(new SearchViewModel(this, binder.recyclerView));
    }
}
