package com.example.appertmentmanagementsystem.Presenters.LoginActivity;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Services.LoginService;
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
public class LoginActivityPresenterImpTest{

    @Mock
    private LoginActivityView view;
    @Mock
    private LoginService service;
    private LoginActivityPresenterImp presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new LoginActivityPresenterImp(view,service);
    }


    @Test
    public void TestEmail(){
        when(view.getEmail()).thenReturn("");
        presenter.CheckForLogin();

        verify(view).showEmailError(R.string.email_error);
    }

    @Test
    public void TestPassword(){
        when(view.getEmail()).thenReturn("Yes");
        when(view.getPassword()).thenReturn("");
        presenter.CheckForLogin();

        verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void TestStartActivity(){
        when(view.getEmail()).thenReturn("Yes");
        when(view.getPassword()).thenReturn("Yes");
        when(service.login("Yes", "Yes")).thenReturn(true);
        presenter.CheckForLogin();

        verify(view).startUserActivity();
    }

    // Failed
    @Test
    public void TestEmailAndPasswordIsValid() throws Exception {
        when(view.getEmail()).thenReturn("Yes");
        when(view.getPassword()).thenReturn("Yes");
        when(service.login("Yes", "Yes")).thenReturn(false);
        presenter.CheckForLogin();

        verify(view).showLoginError(R.string.login_failed);
    }




}