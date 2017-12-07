package com.dstyo.prelo.base;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class BasePresenter<V, VM> {

    protected V view;
    protected VM viewModel;

    public void setView(V view) {
        this.view = view;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }
}