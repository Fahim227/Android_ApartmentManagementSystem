package com.example.appertmentmanagementsystem.Presenters.PayBillActivity;

import com.example.appertmentmanagementsystem.Presenters.RegisterPresenter.RegisterPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmeAddFlattViewntmanagementsystem.Views.PayBill.PayBillActivityView;
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
public class PayBillPresenterImpTest{

    @Mock
    private PayBillActivityView view;
    @Mock
    private PayBillPresenterImp presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new PayBillPresenterImp(view);
    }

    @Test
    public void TestUserID(){
        when(view.getUserID()).thenReturn("");
        presenter.sendBill();

        verify(view).showUserIdError(R.string.userID_error);
    }
    @Test
    public void TestBillType(){
        when(view.getUserID()).thenReturn("1");
        when(view.getBillType()).thenReturn("");
        presenter.sendBill();

        verify(view).showBillTypeError(R.string.billtype_error);
    }
    @Test
    public void TestBillNumber(){
        when(view.getUserID()).thenReturn("1");
        when(view.getBillType()).thenReturn("water");
        when(view.getBillNumber()).thenReturn("");
        presenter.sendBill();

        verify(view).showBillNumberError(R.string.billnumber_error);
    }
    @Test
    public void TestAmount(){
        when(view.getUserID()).thenReturn("1");
        when(view.getBillType()).thenReturn("water");
        when(view.getBillNumber()).thenReturn("01012222");
        when(view.getBillAmount()).thenReturn("");
        presenter.sendBill();;

        verify(view).showBillAmountError(R.string.amount_error);
    }
    @Test
    public void TestBillMonth(){
        when(view.getUserID()).thenReturn("1");
        when(view.getBillType()).thenReturn("water");
        when(view.getBillNumber()).thenReturn("01012222");
        when(view.getBillAmount()).thenReturn("2000");
        when(view.getMonth()).thenReturn("");
        presenter.sendBill();;

        verify(view).showMonthError(R.string.month_error);
    }


}