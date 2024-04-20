package com.mywebmanager.interfaces;

import com.mywebmanager.models.Category_Perfume;
import java.util.List;

public interface DAOCategoria_Perfume {

    public void register(Category_Perfume object) throws Exception;

    public void modify(Category_Perfume object) throws Exception;

    public void delete(int Category_Perfume_Id) throws Exception;

    public List<Category_Perfume> list() throws Exception;

    public Category_Perfume getCategoria_PerfumeById(int Category_Perfume_Id);
}
