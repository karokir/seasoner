package pl.karol.k.seasoner;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.karol.k.seasoner.seasoning.SeasoningItem;
import pl.karol.k.seasoner.util.ContentProvider;
import pl.karol.k.seasoner.util.SeasoningDecorator;

/**
 * A fragment representing a single Seasoning detail screen. This fragment is
 * either contained in a {@link SeasoningListActivity} in two-pane mode (on
 * tablets) or a {@link SeasoningDetailActivity} on handsets.
 */
public class SeasoningDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The content this fragment is presenting.
	 */
	private SeasoningItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public SeasoningDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = ContentProvider.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_seasoning_detail, container, false);

		if (mItem != null) {
			SeasoningDecorator seasoningDecorator = new SeasoningDecorator(mItem, getResources().getString(R.string.suggested_use));
			String formattedSeasoning = seasoningDecorator.getFormattedString();
			((TextView) rootView.findViewById(R.id.seasoning_detail)).setText(Html.fromHtml(formattedSeasoning));
		}

		return rootView;
	}
}
