package com.example.appertmentmanagementsystem.Presenters.Report;

import com.example.appertmentmanagementsystem.Presenters.LoginActivity.LoginActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Services.LoginService;
import com.example.appertmentmanagementsystem.Views.Login.LoginActivityView;
import com.example.appertmentmanagementsystem.Views.Report.ReportView;
import com.example.appertmentmanagementsystem.models.Response;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportPresenterImpTest{


    @Mock
    private ReportView view;
    @Mock
    private ReportPresenterImp presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new ReportPresenterImp(view);
    }

    @Test
    public void TestUserId(){
        when(view.getUserId()).thenReturn("");
        presenter.sendReport();

        verify(view).showUserIDError(R.string.userID_error);
    }


    @Test
    public void TestTitle(){
        when(view.getUserId()).thenReturn("1");
        when(view.get_title()).thenReturn("");
        presenter.sendReport();

        verify(view).showTitleError(R.string.title_error);
    }


    @Test
    public void TestHomeAddress(){
        when(view.getUserId()).thenReturn("1");
        when(view.get_title()).thenReturn("report");
        when(view.getHomeAddress()).thenReturn("");
        presenter.sendReport();

        verify(view).showHomeAddressError(R.string.home_error);
    }


    @Test
    public void TestPoliceStation(){
        when(view.getUserId()).thenReturn("1");
        when(view.get_title()).thenReturn("report");
        when(view.getHomeAddress()).thenReturn("Dhanmondi");
        when(view.getPoliceStation()).thenReturn("");
        presenter.sendReport();

        verify(view).showPoliceStationError(R.string.station_error);
    }


    @Test
    public void TestDescription(){
        when(view.getUserId()).thenReturn("1");
        when(view.get_title()).thenReturn("report");
        when(view.getHomeAddress()).thenReturn("Dhanmondi");
        when(view.getPoliceStation()).thenReturn("Dhanmondi");
        when(view.getDescription()).thenReturn("");
        presenter.sendReport();

        verify(view).showDescriptionError(R.string.description_error);
    }

    @Test
    public void TestReport(){
        when(view.getUserId()).thenReturn("1");
        when(view.get_title()).thenReturn("report");
        when(view.getHomeAddress()).thenReturn("Dhanmondi");
        when(view.getPoliceStation()).thenReturn("Dhanmondi");
        when(view.getDescription()).thenReturn(String.valueOf(R.string.des));
        presenter.sendReport();

        Response res = new Response(true,"Saved Successfully");
        verify(view).getResponse(res);
    }




}