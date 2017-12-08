package com.dstyo.prelo.activity.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.dstyo.prelo.BaseApplication;
import com.dstyo.prelo.R;
import com.dstyo.prelo.adapter.ProductAdapter;
import com.dstyo.prelo.base.BaseActivity;
import com.dstyo.prelo.databinding.ActivityMainBinding;
import com.dstyo.prelo.databinding.NavHeaderMainBinding;
import com.dstyo.prelo.model.login.LoginData;
import com.dstyo.prelo.model.product.Product;
import com.dstyo.prelo.model.product.ProductResponse;
import com.dstyo.prelo.network.api.ApiService;
import com.dstyo.prelo.util.Const;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel, MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    private LoginData loginData;

    @Inject
    public ApiService apiService;

    @Override
    protected void initInjection() {
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initViewModel() {
        viewModel = new MainViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(apiService);
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        init();
        if (loginData != null) {
            fetchDataProduct(loginData.getToken());
        }
    }

    private void init() {
        setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavHeaderMainBinding navBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, binding
                        .navView, false);

        binding.navView.addHeaderView(navBinding.getRoot());
        binding.navView.setNavigationItemSelectedListener(this);


        if (getIntent().getExtras() != null) {
            loginData = getIntent().getExtras().getParcelable(Const.LOGIN);
        }

        navBinding.setViewModel(new ProfileViewModel(loginData));

        MainHandler handler = new MainHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_lovelist) {
            presenter.reloadProducList(loginData.getToken());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void shoProgressLoading() {
        presenter.showLoading();
    }

    @Override
    public void hideProgressLoading() {
        presenter.hideLoading();
    }

    @Override
    public void fetchDataProduct(String token) {
        presenter.getProductList(token);
    }

    @Override
    public void onSuccessFetchProduct(final ProductResponse productResponse) {
        ProductAdapter adapter = new ProductAdapter(productResponse, new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Product product = productResponse.getData().get(position);
                String name = product.getName();
                String price = String.valueOf(product.getPrice());
                Snackbar.make(binding.list, name + " : Rp. " + price, Snackbar.LENGTH_LONG).show();
            }
        });
        binding.list.setAdapter(adapter);
    }

    @Override
    public void onErrorFetchProduct(String error) {
        Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_LONG).show();
    }
}
