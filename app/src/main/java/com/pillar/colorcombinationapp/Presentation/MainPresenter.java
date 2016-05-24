package com.pillar.colorcombinationapp.Presentation;

import com.pillar.colorcombinationapp.R;

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
        } else {

            if (Integer.parseInt(value) > 5 || Integer.parseInt(value) < 1) {
                view.showNoOfMembersOutofRangeError(R.string.max_members_error);
            }
            else {
                view.startProcessing(Integer.parseInt(value));
            }
        }
    }
}