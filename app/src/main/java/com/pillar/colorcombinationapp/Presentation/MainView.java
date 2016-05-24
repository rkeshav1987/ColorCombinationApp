package com.pillar.colorcombinationapp.Presentation;

public interface MainView {

    String getNoOfMembersValue();

    void showNoOfMembersEmptyError(int resId);

    void showNoOfMembersOutofRangeError(int resId);

    void startProcessing(int count);

}
