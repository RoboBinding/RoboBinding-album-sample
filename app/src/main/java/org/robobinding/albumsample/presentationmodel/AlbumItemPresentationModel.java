package org.robobinding.albumsample.presentationmodel;

import android.util.Log;

import org.robobinding.albumsample.model.Album;
import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * @author Robert Taylor
 * @since 1.0
 */
public class AlbumItemPresentationModel implements ItemPresentationModel<Album> {
    protected Album album;

    public String getTitle() {
        Log.d(AlbumItemPresentationModel.class.getSimpleName(), "in getTitle");
        return album.getTitle();
    }

    public String getArtist() {
        return album.getArtist();
    }

    @Override
    public void updateData(Album bean, ItemContext itemContext) {
        Log.d(AlbumItemPresentationModel.class.getSimpleName(), "in updateData");
        this.album = bean;
    }
}
