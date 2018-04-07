package com.nklongyi.Service;

import com.nklongyi.Dao.Columns;
import com.nklongyi.Respository.ColumnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by longyi on 2017/8/24.
 */
@Service
public class ColumnsService {
    @Autowired
    ColumnsRepository columnsRepository;

    public List<Columns> findAll(){
        return columnsRepository.findAll();
    }

    public Columns findById(long id){
        return columnsRepository.findById(id);
    }

    public Columns findByName(String name){
        return columnsRepository.findByName(name);
    }

    public Columns save(Columns columns){
        return columnsRepository.save(columns);
    }

    @Transactional
    public void deleteById(long id){
        columnsRepository.deleteById(id);
    }
}
