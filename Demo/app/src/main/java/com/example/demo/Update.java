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
 * Use the {@link Update#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Update extends Fragment {
    DatabaseManager dbm;
    EditText restID,restName,restLocation;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Update() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Update.
     */
    // TODO: Rename and change types and number of parameters
    public static Update newInstance(String param1, String param2) {
        Update fragment = new Update();
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
        dbm=new DatabaseManager(getActivity());
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);

        restID=(EditText)view.findViewById(R.id.editID);
        restName=(EditText)view.findViewById(R.id.editName);
        restLocation=(EditText)view.findViewById(R.id.editLocation);

        Button udBtn=view.findViewById(R.id.updateButton);
        udBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rating=new Random();
                if(restName.getText().toString().equals("")||restLocation.getText().toString().equals("")||restID.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter All Fields",Toast.LENGTH_LONG).show();

                }
                else
                {
                    boolean ins = dbm.insertRecord(restName.getText().toString(), restLocation.getText().toString(), rating.nextInt(5) + 1,Integer.parseInt(restID.getText().toString()));
                    if (ins) {
                        Toast.makeText(getActivity(), "Record Updated", Toast.LENGTH_LONG).show();
                        restName.setText("");
                        restLocation.setText("");
                        restID.setText("");
                    }
                    else
                        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_LONG).show();
                }
            }

        });
        return view;

    }
}