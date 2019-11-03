package gps.map.navigator.view.viewmodel.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gps.map.navigator.R;
import gps.map.navigator.common.debug.Logger;
import gps.map.navigator.model.interfaces.IMapPlace;
import gps.map.navigator.view.ui.fragment.listener.IPlacePickerCallback;

class MapPlaceViewHolder extends RecyclerView.ViewHolder {

    private ImageView favouriteImage;
    private TextView titleView;
    private TextView addressView;
    private IMapPlace mapPlace;

    MapPlaceViewHolder(@NonNull View itemView, final IPlacePickerCallback fragment) {
        super(itemView);
        favouriteImage = itemView.findViewById(R.id.favourite_map_place);
        favouriteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.debug("Requested mark as favourite of: " + titleView.getText().toString());
                if (mapPlace.isFavourite()) {
                    fragment.markAdNotFavouritePlace(mapPlace);
                } else {
                    fragment.markAdFavouritePlace(mapPlace);
                }
            }
        });
        titleView = itemView.findViewById(R.id.map_place_title);
        addressView = itemView.findViewById(R.id.map_place_address);
        ImageView deleteButton = itemView.findViewById(R.id.delete_map_place);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.debug("Requested deleting of: " + titleView.getText().toString());
                fragment.deleteHistoryPlace(getAdapterPosition(), mapPlace);
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragment != null && mapPlace != null) {
                    fragment.setNewPickedPlace(mapPlace);
                }
            }
        });
    }

    void setMapPlace(IMapPlace mapPlace) {
        this.mapPlace = mapPlace;
        setPlaceFavourite(mapPlace.isFavourite());
        setTitle(mapPlace.getTitle());
        setAddress(mapPlace.getAddress());
    }

    private void setPlaceFavourite(boolean favourite) {
        if (favourite) {
            favouriteImage.setImageResource(android.R.drawable.star_big_on);
        } else {
            favouriteImage.setImageResource(android.R.drawable.star_big_off);
        }
    }

    private void setTitle(String placeTitle) {
        titleView.setText(placeTitle);
    }

    private void setAddress(String address) {
        addressView.setText(address);
    }
}
