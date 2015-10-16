package com.example.kobayashi_ma.enquete;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
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
	private static int lastId = -1;
	private static int returnId = 0;

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
		lastId = 0;
		returnId = 1;
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
	public void onViewCreated(final View view, Bundle savedInstanceState) {
		enquete = serviceImpl.init();
		TextView name = (TextView) view.findViewById(R.id.enquete_name);
		name.setText(enquete.getName());
		TextView firstChoiceName = (TextView) view.findViewById(R.id.first_choice_name);
		RelativeLayout firstChoiceButton = (RelativeLayout) view.findViewById(
				R.id.first_choice_button);

		//TODO:選択肢のマジックコード化を無くす
		firstChoiceName.setText(enquete.getChoiceList().get(0).getName());
		firstChoiceButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				addSeal(v);
			}
		});
		TextView secondChoiceName = (TextView) this.getActivity().findViewById(R.id
				.second_choice_name);
		Button secondChoiceButton = (Button) this.getActivity().findViewById(R.id
				.second_choice_button);
		secondChoiceName.setText(enquete.getChoiceList().get(1).getName());
		secondChoiceButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				answer(enquete.getChoiceList().get(1));
			}
		});
	}

	private void addSeal(View v) {
		RelativeLayout firstChoiceButton = (RelativeLayout) v.findViewById(
				R.id.first_choice_button);
		answer(enquete.getChoiceList().get(0));
		Button button = new Button(getActivity().getBaseContext());
		//TODO:ID
		button.setId(lastId + 1);
		button.setBackgroundResource(R.drawable.first_choice_seal);
		//TODO:シール風アンケートシートの実装
		//折り返して○を表示する
		//親からの相対位置を取得して、タッチ位置と比較した位置に、円を描画する
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(30, 30);
		lp.setMargins(10, 0, 0, 10);
		if (lastId != 0) {
			int margin = 10;
			int buttonWidth = 30;
			int[] location = new int[2];
			firstChoiceButton.getChildAt(lastId - 1).getLocationOnScreen(location);
			int total = location[0] + buttonWidth + margin;
			int w = buttonWidth + margin;
			int max = firstChoiceButton.getWidth();
			if (max > total + w) {
				lp.addRule(RelativeLayout.ALIGN_TOP, lastId);
				lp.addRule(RelativeLayout.RIGHT_OF, lastId);
			}
			// 超えたら下に出す
			else {
				lp.addRule(RelativeLayout.BELOW, returnId);
				returnId = button.getId();
			}
		}
		firstChoiceButton.addView(button, lp);
		lastId++;
		Log.d("lastId:returnId", String.valueOf(lastId) + ":" + String.valueOf(returnId));
	}

	public void answer(Choice choice) {
		serviceImpl.answer(choice);
	}

	public void back() {

	}

	public void moveTotal() {

	}
}