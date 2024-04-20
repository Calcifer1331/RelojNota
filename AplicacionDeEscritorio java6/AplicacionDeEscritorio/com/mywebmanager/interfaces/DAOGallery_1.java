package com.mywebmanager.interfaces;

import com.mywebmanager.models.Gallery;

public interface DAOGallery {

    public void modify(Gallery object) throws Exception;

    public Gallery getGallery();
}
