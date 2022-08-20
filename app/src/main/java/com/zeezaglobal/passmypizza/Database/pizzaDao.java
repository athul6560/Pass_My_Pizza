package com.zeezaglobal.passmypizza.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.zeezaglobal.passmypizza.Data.Pizza;

import java.util.List;

@Dao
public interface pizzaDao {
    @Query("SELECT * FROM pizza")
    List<Pizza> getAll();

    @Query("SELECT * FROM pizza WHERE id IN (:pizzaId)")
    List<Pizza> loadAllByIds(int[] pizzaId);

    @Query("SELECT * FROM pizza WHERE pizzaName LIKE :first  LIMIT 1")
    Pizza findByName(String first);

    @Insert
    void insertAll(Pizza... pizzas);

    @Insert
    void insert(Pizza pizza);

    @Delete
    void delete(Pizza pizza);
}
