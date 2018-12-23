package com.example.test_task;

import com.example.test_task.model.PopulationmainEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PopRepos extends CrudRepository<PopulationmainEntity,String> {
    @Query("select p.country from PopulationmainEntity p")
    List<String> getAllByCountry();

    @Query(value = "\tSELECT p.city,p.pop_number\n" +
            "\tFROM populationmain p where p.country=?1 and p.pop_number <> ''\n" +
            "\tORDER BY cast(p.pop_number as float) ASC limit(3)",nativeQuery = true)
    List<Object[][]> getCitiesByPop(String countryName);



}
