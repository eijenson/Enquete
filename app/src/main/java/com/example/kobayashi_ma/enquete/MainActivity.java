package com.example.kobayashi_ma.enquete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kobayashi_ma.enquete.util.FragmentManagerUtil;


public class MainActivity extends AppCompatActivity implements EnqueteListFragment.ListFragmentListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManagerUtil.fragmentRepalceFirst(this, EnqueteListFragment.newInstance());
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		int backStackCnt = getFragmentManager().getBackStackEntryCount();
		if (backStackCnt != 0) {
			getFragmentManager().popBackStack();
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public void moveAnswerFragment(Long enqueteId) {
		FragmentManagerUtil.fragmentRepalce(this, EnqueteAnswerFragment.newInstance(enqueteId));
	}

	@Override
	public void moveTotalFragment(Long enqueteId) {
		FragmentManagerUtil.fragmentRepalce(this, EnqueteTotalFragment.newInstance(enqueteId));
	}
}
