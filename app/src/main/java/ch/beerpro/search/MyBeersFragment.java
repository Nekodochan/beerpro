package ch.beerpro.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ch.beerpro.R;
import ch.beerpro.models.Beer;
import ch.beerpro.search.adapters.MyBeersRecyclerViewAdapter;

import java.util.List;

public class MyBeersFragment extends Fragment {

    private static final String TAG = "MyBeersFragment";

    private OnItemSelectedListener mListener;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.emptyView)
    View emptyView;

    private MyBeersRecyclerViewAdapter adapter;

    public MyBeersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_searchresult_list, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyBeersRecyclerViewAdapter(mListener);

        SearchActivityViewModel model = ViewModelProviders.of(getActivity()).get(SearchActivityViewModel.class);
        model.getAllBeers().observe(getActivity(), this::handleBeersChanged);

        recyclerView.setAdapter(adapter);
        return view;
    }

    private void handleBeersChanged(List<Beer> beers) {
        adapter.submitList(beers);
        if (beers.isEmpty()) {
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            mListener = (OnItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnItemSelectedListener {
        void onMyBeersListItemSelected(Beer item);
    }
}