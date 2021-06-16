package com.example.insuranceapp.ui.CustomerDetailsForm;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.insuranceapp.R;
import com.example.insuranceapp.ui.home.HomeActivity;

public class CustomerFormFragment extends Fragment {
    private HomeActivity activity;
    private CustomerFormViewModel mViewModel;

    public CustomerFormFragment(HomeActivity activity) {
        this.activity=activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View custView= inflater.inflate(R.layout.customer_form_fragment, container, false);

        EditText custName=custView.findViewById(R.id.cust_edit_name);
        EditText custEmail=custView.findViewById(R.id.cust_edit_email);
        EditText custAddress=custView.findViewById(R.id.cust_edit_address);
        EditText custPhone=custView.findViewById(R.id.cust_edit_phone);
        EditText custDeviceName=custView.findViewById(R.id.cust_edit_device_name);
        EditText custDeviceNumber=custView.findViewById(R.id.cust_edit_device_number);
        EditText custInsureTenure=custView.findViewById(R.id.cust_insur_tenure);
        Button custRegister=custView.findViewById(R.id.cust_Insurance_register);
      custRegister.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

          }
      });

      return custView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CustomerFormViewModel.class);
        // TODO: Use the ViewModel
    }

}