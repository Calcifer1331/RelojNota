package com.mywebmanager.interfaces;

import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Features;
import java.util.List;

public interface DAOFeatures {

    public void modify(Features object) throws Exception;

    public List<Features> list() throws Exception;

    public Features getById(int Features_Id);
}
