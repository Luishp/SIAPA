package com.siapa.service.generic;

import com.siapa.dao.generic.GenericDao;
import com.siapa.utils.PagedResult;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericService<T, ID extends Serializable> {

    public abstract GenericDao<T, ID> getDao();

    public List<T> findAll() {
        return getDao().findAll();
    }

    public T findById(ID id) {
        return getDao().findById(id);
    }

    public Serializable save(T entity) {
        return getDao().save(entity);
    }

    public T merge(T entity) {
        return getDao().merge(entity);
    }

    public void delete(T entity) {
        getDao().delete(entity);
    }

    public PagedResult getPage(int page, int pageSize, String sortProperty, String sortDirection, Object sample) {
        return getDao().getPage(page, pageSize, sortProperty, sortDirection, sample);
    }

    public PagedResult getPage(int page, int pageSize, String sortProperty, String sortDirection) {
        return getDao().getPage(page, pageSize, sortProperty, sortDirection);
    }
    
    public PagedResult getPage(int page, int pageSize, String sortProperty, String sortDirection, List criterions){
        return getDao().getPage(page, pageSize, sortProperty, sortDirection, criterions);
    }
    
    public PagedResult getPageAsesoria(int page, int pageSize, String sortProperty, String sortDirection, List criterions){
        return getDao().getPageAsesoria(page, pageSize, sortProperty, sortDirection, criterions);
    }
}
