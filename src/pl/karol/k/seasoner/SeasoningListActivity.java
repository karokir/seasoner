package pl.karol.k.seasoner;

import java.util.Calendar;

import pl.karol.k.seasoner.util.ContentProvider;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

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

	private final int bDayDay = 7;
	private final int bDayMonth = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seasoning_list);

		if (savedInstanceState == null) {
			ContentProvider.populateItemContainers(this);
		}

		if (findViewById(R.id.seasoning_detail_container) != null) {
			mTwoPane = true;

			((SeasoningListFragment) getFragmentManager().findFragmentById(R.id.seasoning_list)).setActivateOnItemClick(true);
		}

		if (bDay()) {
			showBDayMessage();
		}

	}

	private boolean bDay() {
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		return (currentDay == bDayDay && currentMonth == bDayMonth);
	}

	private void showBDayMessage() {
		Context context = getApplicationContext();
		String message = getString(R.string.happybday);
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, message, duration);
		toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

	/**
	 * Callback method from {@link SeasoningListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(SeasoningDetailFragment.ARG_ITEM_ID, id);
			SeasoningDetailFragment fragment = new SeasoningDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().replace(R.id.seasoning_detail_container, fragment).commit();
		} else {
			Intent detailIntent = new Intent(this, SeasoningDetailActivity.class);
			detailIntent.putExtra(SeasoningDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
