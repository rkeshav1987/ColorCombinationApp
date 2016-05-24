package com.pillar.colorcombinationapp.Presentation;

import com.pillar.colorcombinationapp.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by RishiS on 5/22/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainView view;
    @Mock
    private ServiceClass serviceClass;
    private MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenter(view,serviceClass);
    }

    @Test
    public void shouldShowErrorMessageWhenNoOfMembersEmpty() throws Exception {

        when(view.getNoOfMembersValue()).thenReturn("");
        presenter.onEnteringValueForNoOfMembers();
        verify(view).showNoOfMembersEmptyError(R.string.no_of_members_empty_error);
    }

    @Test
    public void shouldShowErrorMessageWhenNoOfMembersIsBeyondRange() throws Exception {
        when(view.getNoOfMembersValue()).thenReturn("7");
        when(view.getNoOfMembersValue()).thenReturn("0");
        presenter.onEnteringValueForNoOfMembers();

        verify(view).showNoOfMembersOutofRangeError(R.string.max_members_error);
    }

    @Test
    public void shouldstartProcessingWhenNoofMembersInputIsCorrect() throws Exception {
        when(view.getNoOfMembersValue()).thenReturn("3");
        presenter.onEnteringValueForNoOfMembers();

        verify(view).startProcessing(3);
    }
}