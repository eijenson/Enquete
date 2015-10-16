package com.example.kobayashi_ma.enquete;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kobayashi_ma.enquete.service.EnqueteListService;
import com.example.kobayashi_ma.enquete.serviceimpl.EnqueteListServiceImpl;


public class EnqueteListFragment extends Fragment {

	private static final String ENQUETE_ID = "enqueteId";
	private EnqueteListService serviceImpl;
	private ListFragmentListener listFragmentListener;

	public static EnqueteListFragment newInstance() {
		EnqueteListFragment fragment = new EnqueteListFragment();
		return fragment;
	}

	public EnqueteListFragment() {
		serviceImpl = new EnqueteListServiceImpl();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_enquete_list, container, false);
	}


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		//TODO:リスト化までコメントアウトserviceImpl.init();
		Button answer = (Button) view.findViewById(R.id.answer);
		//TODO:選択肢のマジックコード化を無くす
		answer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listFragmentListener.moveAnswerFragment((long) 0);
			}
		});
		Button total = (Button) this.getActivity().findViewById(R.id.total);
		total.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listFragmentListener.moveTotalFragment((long) 0);
			}
		});
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listFragmentListener = (ListFragmentListener) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		listFragmentListener = null;
	}

	public interface ListFragmentListener {
		//TODO:アンケートIDを使用する
		void moveAnswerFragment(Long enqueteId);

		void moveTotalFragment(Long enqueteId);

		void moveCreateFragment();
	}
}
