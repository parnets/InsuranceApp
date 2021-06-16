package com.example.insuranceapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.insuranceapp.R;
import com.example.insuranceapp.data.model.InsurancePlan;
import com.example.insuranceapp.ui.CustomerDetailsForm.CustomerFormFragment;


import java.util.List;


public class InsurancePlanAdapter extends RecyclerView.Adapter<InsurancePlanAdapter.PlanViewHolder> {
    private static  final  String TAG="InsurancePlanAdapter";
    private List<InsurancePlan> plans;
    private HomeActivity homeActivity;

    public InsurancePlanAdapter(HomeActivity activity, List<InsurancePlan> plans){
        this.plans=plans;
        this.homeActivity=activity;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.insurance_plan,parent,false);
        PlanViewHolder viewHolder = new PlanViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {
        holder.planCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = homeActivity.getSupportFragmentManager();
                CustomerFormFragment customerFormFragment=new CustomerFormFragment(homeActivity);
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_container,customerFormFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
         holder.planImage.setImageResource(R.drawable.app_icon_foreground);
         holder.planName.setText(plans.get(position).getPlanName());
         holder.planDesc.setText(plans.get(position).getPlanDescription());
         holder.planTenure.setText(plans.get(position).getPlanTenure());
         holder.planPrice.setText(plans.get(position).getPlanPrice());
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }



    public class PlanViewHolder extends ViewHolder {
             public CardView planCard;
             public TextView planName;
             public TextView planDesc;
             public TextView planTenure;
             public TextView planPrice;
             public ImageView planImage;

        public PlanViewHolder(@NonNull View iView) {
            super(iView);
            planCard=iView.findViewById(R.id.insurance_plan_card);
           planImage=iView.findViewById(R.id.planImage);
            planDesc=iView.findViewById(R.id.planName);
            planTenure=iView.findViewById(R.id.planDescrisption);
            planPrice=iView.findViewById(R.id.planPrice);
        }
    }
}
