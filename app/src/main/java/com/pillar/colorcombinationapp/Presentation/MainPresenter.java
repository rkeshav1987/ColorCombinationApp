package com.pillar.colorcombinationapp.Presentation;

/**
 * Created by RishiS on 5/23/2016.
 */
public class MainPresenter {

    private MainView view;
    private ServiceClass serviceClass;

    public MainPresenter(MainView view, ServiceClass serviceClass) {
        this.view = view;
        this.serviceClass = serviceClass;
    }

    public void onEnteringValueForNoOfMembers() {

    }
}