package com.example.kobayashi_ma.enquete.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.kobayashi_ma.enquete.R;

/**
 * フラグメントの画面遷移系の処理を統括する
 * Created by kobayashi-ma on 2015/09/04.
 */
public class FragmentManagerUtil {
	FragmentManager manager;
	FragmentTransaction transaction;

	/**
	 * 指定されたfragmentへ画面を入れ替える
	 *
	 * @param activity
	 * @param fragment
	 */
	public static void fragmentRepalce(Activity activity, Fragment fragment) {
		FragmentManager manager = activity.getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.container, fragment).addToBackStack(null).commit();
	}

	public static void fragmentRepalceFirst(Activity activity, Fragment fragment) {
		FragmentManager manager = activity.getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.container, fragment).commit();
	}
}
