package com.nklongyi.Respository;

import com.nklongyi.Dao.Columns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by longyi on 2017/8/24.
 */
public interface ColumnsRepository extends JpaRepository<Columns,Long> {
    List<Columns> findAll();
    Columns findById(long id);
    Columns findByName(String name);
    Columns  save(Columns columns);
    void deleteById(long id);

}
