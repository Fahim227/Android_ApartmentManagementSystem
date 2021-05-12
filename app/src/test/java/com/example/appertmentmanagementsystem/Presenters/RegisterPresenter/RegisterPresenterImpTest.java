package com.example.appertmentmanagementsystem.Presenters.RegisterPresenter;

import com.example.appertmentmanagementsystem.Presenters.LoginActivity.LoginActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Services.LoginService;
import com.example.appertmentmanagementsystem.Views.Login.LoginActivityView;
import com.example.appertmentmanagementsystem.Views.Register.MainActivityView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterPresenterImpTest{

    @Mock
    private MainActivityView view;
    @Mock
    private RegisterPresenterImp presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new RegisterPresenterImp(view);
    }


    @Test
    public void TestFirstName(){
        when(view.getFirstname()).thenReturn("");
        presenter.registerUser();

        verify(view).showFirstNameError(R.string.name_erro);
    }

    @Test
    public void TestLastName(){
        when(view.getFirstname()).thenReturn("Fahim");
        when(view.getLastName()).thenReturn("");
        presenter.registerUser();

        verify(view).showLastNameError(R.string.name_erro);
    }
    @Test
    public void TestEmail(){
        when(view.getFirstname()).thenReturn("Fahim");
        when(view.getLastName()).thenReturn("Islam");
        when(view.getEmail()).thenReturn("");
        presenter.registerUser();

        verify(view).showEmailError(R.string.email_error);
    }

    @Test
    public void TestPhoneNumber(){
        when(view.getFirstname()).thenReturn("Fahim");
        when(view.getLastName()).thenReturn("Islam");
        when(view.getEmail()).thenReturn("fahim@gmail.com");
        when(view.getPhoneNumer()).thenReturn("019");
        presenter.registerUser();

        verify(view).showPhonNumberError(R.string.phone_error);
    }

    @Test
    public void TestPassword(){
        when(view.getFirstname()).thenReturn("Fahim");
        when(view.getLastName()).thenReturn("Islam");
        when(view.getEmail()).thenReturn("fahim@gmail.com");
        when(view.getPhoneNumer()).thenReturn("01900000000");
        when(view.getPassword()).thenReturn("");
        presenter.registerUser();

        verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void TestConPassword(){
        when(view.getFirstname()).thenReturn("Fahim");
        when(view.getLastName()).thenReturn("Islam");
        when(view.getEmail()).thenReturn("fahim@gmail.com");
        when(view.getPhoneNumer()).thenReturn("01900000000");
        when(view.getPassword()).thenReturn("1111");
        when(view.getConPassword()).thenReturn("111");
        presenter.registerUser();

        verify(view).showConPasswordError(R.string.con_password_error);
    }


}