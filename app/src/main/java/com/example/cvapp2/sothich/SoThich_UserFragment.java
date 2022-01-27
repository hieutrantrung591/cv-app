package com.example.cvapp2.sothich;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cvapp2.MainActivity;
import com.example.cvapp2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SoThich_UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SoThich_UserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText edHobby;
    Button btnSave,btnCancel;
    SQLHobby sqlHobby;
    public SoThich_UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SoThich_UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SoThich_UserFragment newInstance(String param1, String param2) {
        SoThich_UserFragment fragment = new SoThich_UserFragment();
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
        View view = inflater.inflate(R.layout.fragment_so_thich__user, container, false);
        sqlHobby = new SQLHobby(getContext());

        edHobby = view.findViewById(R.id.userHobby);
        btnSave = view.findViewById(R.id.buttonSave);
        btnCancel = view.findViewById(R.id.buttonDelete);

        Intent intent = getActivity().getIntent();
        edHobby.setText(intent.getStringExtra(MainActivity.HOBBY));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hobby hobby = createHobby();
                sqlHobby.addHobby(hobby);

                Intent intent1 = new Intent( getActivity(), MainActivity.class);
                startActivity(intent1);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHobby.deleteHobby();

                Intent intent2 = new Intent(getActivity(),MainActivity.class);
                startActivity(intent2);
            }
        });

        return view;
    }

    public Hobby createHobby(){
        Hobby hobby = new Hobby(edHobby.getText().toString());

        return hobby;
    }
}