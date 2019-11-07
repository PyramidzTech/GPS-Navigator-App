package gps.map.navigator.view.viewmodel.recyclerview;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import gps.map.navigator.model.interfaces.IMapPlace;

public class AdapterFilter extends Filter {

    private AbstractAdapter adapter;

    AdapterFilter(AbstractAdapter adapter) {
        this.adapter = adapter;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.changePlacesList((List<IMapPlace>) results.values);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        List<IMapPlace> filteredResults;
        if (constraint.length() == 0) {
            filteredResults = adapter.getOriginalPlacesList();
        } else {
            filteredResults = getFilteredResults(adapter.getOriginalPlacesList(), constraint.toString().toLowerCase());
        }

        FilterResults results = new FilterResults();
        results.values = filteredResults;

        return results;
    }

    private List<IMapPlace> getFilteredResults(List<IMapPlace> originalPlacesList, String constraint) {
        List<IMapPlace> results = new ArrayList<>();
        if (originalPlacesList != null) {
            String title;
            String adress;
            for (IMapPlace item : originalPlacesList) {
                title = item.getTitle().toLowerCase();
                adress = item.getAddress().toLowerCase();
                if (title.contains(constraint) || adress.contains(constraint)) {
                    results.add(item);
                }
            }
        }
        return results;
    }
}
