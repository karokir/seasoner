package pl.karol.k.seasoner;

import pl.karol.k.seasoner.seasoning.ContentProvider;
import pl.karol.k.seasoner.seasoning.SeasoningItem;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;
import android.app.Activity;
import android.app.Application;

/**
 * An activity representing a list of Seasonings. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link SeasoningDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link SeasoningListFragment} and the item details (if present) is a
 * {@link SeasoningDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link SeasoningListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class SeasoningListActivity extends Activity implements SeasoningListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seasoning_list);

		if (findViewById(R.id.seasoning_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((SeasoningListFragment) getFragmentManager().findFragmentById(R.id.seasoning_list)).setActivateOnItemClick(true);
		}

//		ContentProvider.populate(this);
		Context context = getApplicationContext();
		String message = getString(R.string.happybday);
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, message, duration);
		toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link SeasoningListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(SeasoningDetailFragment.ARG_ITEM_ID, id);
			SeasoningDetailFragment fragment = new SeasoningDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().replace(R.id.seasoning_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, SeasoningDetailActivity.class);
			detailIntent.putExtra(SeasoningDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
