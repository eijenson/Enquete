package com.example.kobayashi_ma.enquete;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kobayashi_ma.enquete.bean.Choice;
import com.example.kobayashi_ma.enquete.bean.Enquete;
import com.example.kobayashi_ma.enquete.service.EnqueteAnswerService;
import com.example.kobayashi_ma.enquete.serviceimpl.EnqueteAnswerServiceImpl;

public class EnqueteAnswerFragment extends Fragment {

	/**
	 * アンケートID
	 */
	private static final String ENQUETE_ID = "enqueteId";
	private EnqueteAnswerService serviceImpl;
	private Enquete enquete;

	public static EnqueteAnswerFragment newInstance(Long EnqueteId) {
		EnqueteAnswerFragment fragment = new EnqueteAnswerFragment();
		Bundle args = new Bundle();
		args.putLong(ENQUETE_ID, EnqueteId);
		fragment.setArguments(args);
		return fragment;
	}

	public EnqueteAnswerFragment() {
		serviceImpl = new EnqueteAnswerServiceImpl();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_enquete_answer, container, false);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		enquete = serviceImpl.init();
		TextView name = (TextView) view.findViewById(R.id.enquete_name);
		name.setText(enquete.getName());
		Button button1 = (Button) view.findViewById(R.id.first_choice);
		//TODO:選択肢のマジックコード化を無くす
		button1.setText(enquete.getChoiceList().get(0).getName());
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				answer(enquete.getChoiceList().get(0));
			}
		});
		Button button2 = (Button) this.getActivity().findViewById(R.id.second_choice);
		button2.setText(enquete.getChoiceList().get(1).getName());
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				answer(enquete.getChoiceList().get(1));
			}
		});
	}

	public void answer(Choice choice) {
		serviceImpl.answer(choice);

	}

	public void back() {

	}

	public void moveTotal() {

	}
}