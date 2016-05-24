package com.pillar.colorcombinationapp.Presentation;

import com.pillar.colorcombinationapp.R;

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
        String value = view.getNoOfMembersValue();

        if (value.isEmpty()) {
            view.showNoOfMembersEmptyError(R.string.no_of_members_empty_error);
        }
    }
}