package com.techpalle.b36_preferenceseg1;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText et1, et2;
    Button b1;
    TextView tv1;
    public LoginFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        et1 = (EditText) v.findViewById(R.id.editText1);
        et2 = (EditText) v.findViewById(R.id.editText2);
        b1 = (Button) v.findViewById(R.id.button1);
        tv1 = (TextView) v.findViewById(R.id.textView1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TASK 4 : CHECK LOGIN
                String uname = et1.getText().toString().trim();
                String pw = et2.getText().toString();
                //open credentials file, and read uname and pw
                SharedPreferences sp = getActivity().getSharedPreferences("credentials",0);
                String original_uname = sp.getString("uname", null);
                String original_pw = sp.getString("pw", null);
                //compare what user entered with original values
                if(uname.equals(original_uname) && pw.equals(original_pw)){
                    tv1.setText("Login Status : SUCCESS");
                }else{
                    tv1.setText("Login Status : FAILURE - TRY AGAIN");
                }
                //END
            }
        });
        return v;
    }

}
