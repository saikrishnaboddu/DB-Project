package com.example.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Insert#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Insert extends Fragment {
DatabaseManager dbm;
    EditText restName, restLoc;
    Button add, addItems, home;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Insert() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Insert.
     */
    // TODO: Rename and change types and number of parameters
    public static Insert newInstance(String param1, String param2) {
        Insert fragment = new Insert();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_insert, container, false);
        restName= view.findViewById(R.id.editRestName);
        restLoc= view.findViewById(R.id.editRestLocation);
        dbm=new DatabaseManager(getActivity());
        add=view.findViewById(R.id.insertBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rating=new Random();
                if(restName.getText().toString().equals("")||restLoc.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter All Fields",Toast.LENGTH_LONG).show();

                }
                else
                {
                    boolean ins = dbm.insertRecord(restName.getText().toString(), restLoc.getText().toString(), rating.nextInt(5) + 1,0);
                    if (ins) {
                        Toast.makeText(getActivity(), "record inserted", Toast.LENGTH_LONG).show();
                        restName.setText("");
                        restLoc.setText("");
                    }
                    else
                        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }



}