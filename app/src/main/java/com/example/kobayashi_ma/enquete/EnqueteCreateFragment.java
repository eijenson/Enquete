package com.example.kobayashi_ma.enquete;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.kobayashi_ma.enquete.bean.Enquete;
import com.example.kobayashi_ma.enquete.dao.EnqueteDao;

import java.util.ArrayList;


public class EnqueteCreateFragment extends Fragment {

	public static EnqueteCreateFragment newInstance() {
		EnqueteCreateFragment fragment = new EnqueteCreateFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public EnqueteCreateFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_enquete_create, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Button createButton = (Button) view.findViewById(R.id.create_button);
		createButton.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//TODO:noスパゲッティ
						//TODO:バリデート実装
						View parentView = v.getRootView();
						String enqueteTitle = ((EditText) parentView.findViewById(
								R.id.new_enquete_name))
								.getText().toString();
						ArrayList<String> choiceTitleList = new ArrayList<>();
						choiceTitleList.add(((EditText) parentView.findViewById(R.id.choice_title1))
								.getText().toString());
						choiceTitleList.add(((EditText) parentView.findViewById(R.id.choice_title2))
								.getText().toString());
						Enquete enquete = new Enquete(enqueteTitle, choiceTitleList);
						EnqueteDao.insertEnquete(enquete);
						//TODO:遷移
					}
				}

		);
	}

	public interface CreateFragmentListener {
		void moveListFragment();
	}
}
