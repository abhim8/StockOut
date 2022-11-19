package com.example.stockout.loginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.stockout.R;
import com.example.stockout.initialDashboard.DashBoard;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignInFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignInFragment extends Fragment {

    private EditText editTextMail, editTextPw;
    private String email, pw;
    private String URL;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        editTextMail = (EditText) view.findViewById(R.id.emailid);
        editTextPw = (EditText) view.findViewById(R.id.pw);

        Button btn = (Button) view.findViewById(R.id.button_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextMail.getText().toString();
                pw = editTextPw.getText().toString();
//              URL = "https://x8ki-letl-twmt.n7.xano.io/api:_4Dpd2h_/auth/login?email=" + email + "&password=" + pw;
                URL = "https://x8ki-letl-twmt.n7.xano.io/api:_4Dpd2h_/auth/login";
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("email",email);
                    jsonObject.put("password",pw);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
//                                  System.err("LOGIN Success");
                                Toast.makeText(getActivity().getApplicationContext(),"Response : Login Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getActivity().getApplicationContext(), DashBoard.class));
                                Log.i("Response ", response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error);
                        Toast.makeText(getActivity().getApplicationContext(),"Response : Login Failed", Toast.LENGTH_LONG).show();
                        Log.e("Error", error.getMessage());

                    }
                });

// Add the request to the RequestQueue.
                queue.add(jsonObjectRequest);
            }
        });
        return view;
    }

}