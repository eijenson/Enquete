package com.example.kobayashi_ma.enquete;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kobayashi_ma.enquete.bean.Enquete;
import com.example.kobayashi_ma.enquete.service.EnqueteTotalService;
import com.example.kobayashi_ma.enquete.serviceimpl.EnqueteTotalServiceImpl;


public class EnqueteTotalFragment extends Fragment {
	private static final String ENQUETE_ID = "enqueteId";
	private EnqueteTotalService serviceImpl;

	public static EnqueteTotalFragment newInstance(Long EnqueteId) {
		EnqueteTotalFragment fragment = new EnqueteTotalFragment();
		Bundle args = new Bundle();
		args.putLong(ENQUETE_ID, EnqueteId);
		fragment.setArguments(args);
		return fragment;
	}

	public EnqueteTotalFragment() {
		serviceImpl = new EnqueteTotalServiceImpl();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_enquete_total, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Enquete enquete = serviceImpl.init(getArguments().getLong(ENQUETE_ID));
		TextView name = (TextView) view.findViewById(R.id.total_enquete_name);
		name.setText(enquete.getName());
		//TODO:選択肢のマジックコード化を無くす
		TextView first = (TextView) view.findViewById(R.id.total_first_choice);
		first.setText("" + enquete.getChoiceList().get(0).getValue());
		TextView second = (TextView) this.getActivity().findViewById(R.id.total_second_choice);
		second.setText("" + enquete.getChoiceList().get(1).getValue());
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
}
