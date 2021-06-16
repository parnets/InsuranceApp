package com.example.insuranceapp.ui.home;

import android.os.Bundle;
import android.view.View;

import com.example.insuranceapp.data.model.InsurancePlan;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insuranceapp.R;

import java.util.LinkedList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private boolean isFABOpen=false;
    private FloatingActionButton fab;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    private  RecyclerView insurancePlan;
    private  InsurancePlanAdapter insurancePlanAdapter;
    private  RecyclerView.LayoutManager planLayoutManager;
    private List<InsurancePlan> insurancePlans=new LinkedList<InsurancePlan>();

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.topAppBar);
        setContentView(R.layout.activity_home);
        setSupportActionBar(toolbar);

         fab = (FloatingActionButton) findViewById(R.id.fab);
       fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
       fab3 = (FloatingActionButton) findViewById(R.id.fab3);

       insurancePlan=findViewById(R.id.insurancePlanRecyclerview);
        planLayoutManager=new LinearLayoutManager(this);
       insurancePlanAdapter=new InsurancePlanAdapter(this,insurancePlans);
       insurancePlan.setLayoutManager(planLayoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });


    }
    private void showFABMenu(){
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
    }


}