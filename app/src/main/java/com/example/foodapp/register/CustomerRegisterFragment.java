package com.example.foodapp.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodapp.R;
import com.example.foodapp.accounts.Customer;
import com.example.foodapp.login.LoginMain;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomerRegisterFragment extends Fragment {

    EditText fName, lName, email, address, mobile, password, confPassword;
    Button btn_ToSignIn, btnReg;
    Customer cus;

    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Customer");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.register_fragment_customer, container, false);

        fName = view.findViewById(R.id.edt_FirstName);
        lName = view.findViewById(R.id.edt_LastName);
        email = view.findViewById(R.id.edt_mail);
        address = view.findViewById(R.id.edt_address);
        mobile = view.findViewById(R.id.edt_mobile);
        password = view.findViewById(R.id.edt_password);
        confPassword = view.findViewById(R.id.edt_conformPassword);
        //btnLog = view.findViewById(R.id.btn_toLogin);
        btnReg = view.findViewById(R.id.btn_reg_signUp);

        cus = new Customer();

        btn_ToSignIn = view.findViewById(R.id.btn_toLogin);

        btn_ToSignIn.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), LoginMain.class);
            startActivity(i);
        });


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //get data from edit text into String variables
                final String fNameTxt = fName.getText().toString();
                final String lNameTxt = lName.getText().toString();
                final String emailTxt = email.getText().toString();
                final String addressTxt = address.getText().toString();
                final String mobileTxt = mobile.getText().toString();
                final String pwdTxt = password.getText().toString();
                final String conPwdTxt = confPassword.getText().toString();

                    if (TextUtils.isEmpty(fNameTxt))
                        Toast.makeText(getActivity(), "Please enter an first name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(lNameTxt))
                        Toast.makeText(getActivity(), "Please enter a last name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(emailTxt))
                        Toast.makeText(getActivity(), "Please enter a email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(addressTxt))
                        Toast.makeText(getActivity(), "Please enter a address", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(mobileTxt))
                        Toast.makeText(getActivity(), "Please enter a mobile", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(pwdTxt))
                        Toast.makeText(getActivity(), "Please enter a password", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(conPwdTxt))
                        Toast.makeText(getActivity(), "Please, confirm the password", Toast.LENGTH_SHORT).show();

                    else if(!pwdTxt.equals(conPwdTxt))
                        Toast.makeText(getActivity(), "Passwords is not matched", Toast.LENGTH_SHORT).show();


                    else {

                        dbRef.child("Customer").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(mobileTxt)){
                                    Toast.makeText(getActivity(), "Phone is already registered", Toast.LENGTH_SHORT).show();
                                }

                                else{

                                    dbRef.child(mobileTxt).child("firstname").setValue(fNameTxt);
                                    dbRef.child(mobileTxt).child("lastname").setValue(lNameTxt);
                                    dbRef.child(mobileTxt).child("email").setValue(emailTxt);
                                    dbRef.child(mobileTxt).child("address").setValue(addressTxt);
                                    //dbRef.child("Customer").child(mobileTxt).child("mobile").setValue(pwdTxt);
                                    dbRef.child(mobileTxt).child("password").setValue(pwdTxt);

                                    /*
                                    cus.setFirstName(fName.getText().toString().trim());
                                    cus.setLastName(lName.getText().toString().trim());
                                    cus.setEmail(email.getText().toString().trim());
                                    cus.setAddress(address.getText().toString().trim());
                                    cus.setMobile(mobile.getText().toString().trim());
                                    //dbRef.push().setValue(std);
                                    dbRef.child(cus.getMobile()).setValue(cus);
                                    Toast.makeText(getActivity(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                                    //clearInputs();

                                     */

                                    Toast.makeText(getActivity(), "You are registered successfully", Toast.LENGTH_SHORT).show();
                                    getActivity().finish();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }


            }
        });

        return view;
    }
}