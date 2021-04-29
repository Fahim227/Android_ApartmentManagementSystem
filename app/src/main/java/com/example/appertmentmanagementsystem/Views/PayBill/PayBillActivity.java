package com.example.appertmentmanagementsystem.Views.PayBill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Adapters.CategoryAdapter;
import com.example.appertmentmanagementsystem.Presenters.PayBillActivityPresenter.PayBillPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.PayBill.PayBillActivityView;
import com.example.appertmentmanagementsystem.models.Paybillmodel;
import com.example.appertmentmanagementsystem.models.Response;

import java.util.ArrayList;
import java.util.List;

public class PayBillActivity extends AppCompatActivity implements PayBillActivityView, View.OnClickListener {

    private List<Paybillmodel> paybillmodelList;
    private RecyclerView bills;
    private CategoryAdapter categoryAdapter;
    private FrameLayout frameLayout;
    PayBillPresenterImp payBillPresenterImp;
    private EditText userid,billtype,billnumber,amount,month;
    private Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);

       /* bills = findViewById(R.id.billID);
        frameLayout = findViewById(R.id.content_frame);*/
        userid = findViewById(R.id.userID);
        billtype = findViewById(R.id.bill_typeID);
        billnumber = findViewById(R.id.bill_NumberID);
        month = findViewById(R.id.bill_monthID);
        amount = findViewById(R.id.amountID);
        pay = findViewById(R.id.pay_ButtonID);
        paybillmodelList = new ArrayList<>();
        payBillPresenterImp = new PayBillPresenterImp(this);

        pay.setOnClickListener(this);

        /*Paybillmodel modelA = new Paybillmodel("Water",R.drawable.water);
        Paybillmodel modelB = new Paybillmodel("Gass",R.drawable.gass);
        Paybillmodel modelC = new Paybillmodel("Electricity",R.drawable.electricity);

        paybillmodelList.add(modelA);
        paybillmodelList.add(modelB);
        paybillmodelList.add(modelC);

        categoryAdapter = new CategoryAdapter(paybillmodelList,getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        bills.setLayoutManager(layoutManager);
        bills.setAdapter(categoryAdapter);

        getSupportFragmentManager().beginTransaction().add(R.id.content_frame,new WaterBillFragment()).commit();*/

    }
   /* public void changeFragment(String str){
        //Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        if (str.equals("water")){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new WaterBillFragment()).commit();
        }
        else if (str.equals("gass")){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new GassBillFragment()).commit();

        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new CurrentBillFragment()).commit();

        }

    }*/

    @Override
    public void getResponse(Response response) {
        Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.pay_ButtonID){
            Paybillmodel model = new Paybillmodel(userid.getText().toString(),billtype.getText().toString(),billnumber.getText().toString(),amount.getText().toString(),month.getText().toString());
            payBillPresenterImp.sendBill(model);
        }

    }
}