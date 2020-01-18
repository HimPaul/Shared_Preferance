package com.techpalle.b36_preferenceseg1;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    EditText et1, et2, et3, et4;
    Button b1;
    public SignUpFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        et1 = (EditText) v.findViewById(R.id.editText1);
        et2 = (EditText) v.findViewById(R.id.editText2);
        et3 = (EditText) v.findViewById(R.id.editText3);
        et4 = (EditText) v.findViewById(R.id.editText4);
        b1 = (Button) v.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TASK 2 : STORE USER CREDENTIALS INTO A PREFERENCE FILE NAMED "credentials.xml"
                String uname = et1.getText().toString().trim();
                String pw = et2.getText().toString();
                String cpw = et3.getText().toString();
                String mobile = et4.getText().toString().trim();
                //check for empty fields
                if(uname.equals("") || pw.equals("") || cpw.equals("") || mobile.equals("")){
                    Toast.makeText(getActivity(), "DONT LEAVE ANY FIELD EMPTY", Toast.LENGTH_SHORT).show();
                    return;
                }
                //let us do pw and cpw validation
                if(pw.equals(cpw) == false){
                    Toast.makeText(getActivity(), "confirm pw is not matching", Toast.LENGTH_SHORT).show();
                    return;
                }
                //ELSE LET US STORE DETAILS INTO PREFERENCE FILE
                SharedPreferences sp = getActivity().getSharedPreferences("credentials",0);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("uname", uname);//username is inserted
                editor.putString("pw", pw); //pw is inserted
                editor.putString("mobile", mobile);//mobile is inserted
                editor.commit();
                //END OF TASK 2
                //CALL MAIN ACTIVITY'S METHOD FOR STARTING TASK 3
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.credentialsSaved();
            }
        });
        return v;
    }

}
