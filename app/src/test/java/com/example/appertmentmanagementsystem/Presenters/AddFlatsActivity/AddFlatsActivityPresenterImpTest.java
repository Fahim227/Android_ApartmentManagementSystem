package com.example.appertmentmanagementsystem.Presenters.AddFlatsActivity;

import com.example.appertmentmanagementsystem.Presenters.LoginActivity.LoginActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Services.LoginService;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlattView;
import com.example.appertmentmanagementsystem.Views.Login.LoginActivityView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddFlatsActivityPresenterImpTest{

    @Mock
    private AddFlattView view;
    @Mock
    private AddFlatsActivityPresenter presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new AddFlatsActivityPresenterImp(view);
    }

    @Test
    public void TestFlatNumber(){
        when(view.getFlatNumber()).thenReturn("");
        presenter.addFlat();

        verify(view).showFlatNumberError(R.string.flat_number_error);
    }

    @Test
    public void TestBuildingNumber(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("");
        presenter.addFlat();

        verify(view).showBuildingNumberError(R.string.building_number_error);
    }
    @Test
    public void TestLocation(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("");
        presenter.addFlat();

        verify(view).showLocationError(R.string.location_error);
    }
    @Test
    public void TestMapAddress(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("dhanmondi");
        when(view.getMapAddress()).thenReturn("");
        presenter.addFlat();

        verify(view).showMapAddressError(R.string.map_address_error);
    }
    @Test
    public void TestFlatSize(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("dhanmondi");
        when(view.getMapAddress()).thenReturn("map.google.com/");
        when(view.getFlatSize()).thenReturn("");
        presenter.addFlat();

        verify(view).showFlatSizeError(R.string.flat_size_error);
    }
    @Test
    public void TestBedNum(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("dhanmondi");
        when(view.getMapAddress()).thenReturn("map.google.com/");
        when(view.getFlatSize()).thenReturn("2400");
        when(view.getBedNum()).thenReturn("");
        presenter.addFlat();

        verify(view).showBedNumError(R.string.bed_num_error);
    }
    @Test
    public void TestBathNum(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("dhanmondi");
        when(view.getMapAddress()).thenReturn("map.google.com/");
        when(view.getFlatSize()).thenReturn("2400");
        when(view.getBedNum()).thenReturn("3");
        when(view.getBathNum()).thenReturn("");
        presenter.addFlat();

        verify(view).showBathNumError(R.string.bath_num_error);
    }
    @Test
    public void TestBelcony(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("dhanmondi");
        when(view.getMapAddress()).thenReturn("map.google.com/");
        when(view.getFlatSize()).thenReturn("2400");
        when(view.getBedNum()).thenReturn("3");
        when(view.getBathNum()).thenReturn("2");
        when(view.getBelconyNum()).thenReturn("");
        presenter.addFlat();

        verify(view).showBelconyNumError(R.string.belcony_num_error);
    }
    @Test
    public void TestPrice(){
        when(view.getFlatNumber()).thenReturn("1");
        when(view.getBuildingNumber()).thenReturn("2");
        when(view.getLocation()).thenReturn("dhanmondi");
        when(view.getMapAddress()).thenReturn("map.google.com/");
        when(view.getFlatSize()).thenReturn("2400");
        when(view.getBedNum()).thenReturn("3");
        when(view.getBathNum()).thenReturn("2");
        when(view.getBelconyNum()).thenReturn("2");
        when(view.getPrice()).thenReturn("");
        presenter.addFlat();

        verify(view).showPriceError(R.string.price_error);
    }


}