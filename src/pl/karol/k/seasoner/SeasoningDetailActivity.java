package pl.karol.k.seasoner;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.MenuItem;

/**
 * An activity representing a single Seasoning detail screen. This activity is
 * only used on handset devices. On tablet-size devices, item details are
 * presented side-by-side with a list of items in a
 * {@link SeasoningListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link SeasoningDetailFragment}.
 */
public class SeasoningDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seasoning_detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(SeasoningDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(SeasoningDetailFragment.ARG_ITEM_ID));
			SeasoningDetailFragment fragment = new SeasoningDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().add(R.id.seasoning_detail_container, fragment).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			navigateUpTo(new Intent(this, SeasoningListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
