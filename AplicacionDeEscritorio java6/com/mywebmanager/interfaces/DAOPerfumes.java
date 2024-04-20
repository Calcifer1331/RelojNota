package com.mywebmanager.interfaces;

import com.mywebmanager.models.Perfumes;
import java.util.List;

public interface DAOPerfumes {

    public void register(Perfumes object) throws Exception;

    public void modify(Perfumes object) throws Exception;

    public void delete(int perfumeId) throws Exception;

    public List<Perfumes> list(int optionSearch, String valueSearch) throws Exception;

    public Perfumes getPerfumeById(int perfumeId) throws Exception;
}
