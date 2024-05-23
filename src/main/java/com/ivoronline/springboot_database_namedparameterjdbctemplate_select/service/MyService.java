package com.ivoronline.springboot_database_namedparameterjdbctemplate_select.service;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_select.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // SELECT RECORD
  //=========================================================================================================
  public PersonDTO selectRecord(Integer id, Integer age) {

    String sql = "SELECT * FROM PERSON WHERE ID = :personId AND AGE = :personAge";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("personId" , id)
      .addValue("personAge", age);

    return (PersonDTO) namedParameterJdbcTemplate.queryForObject(
        sql
      , parameters
      , new BeanPropertyRowMapper(PersonDTO.class)
    );

  }

  //=========================================================================================================
  // SELECT RECORDS
  //=========================================================================================================
  public List<PersonDTO> selectRecords(Integer id, Integer age) {

    String sql = "SELECT * FROM PERSON WHERE ID > :personId AND AGE > :personAge";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("personId" , id)
      .addValue("personAge", age);

    return namedParameterJdbcTemplate.query(
        sql
      , parameters
      , new BeanPropertyRowMapper(PersonDTO.class)
    );

  }

  //=========================================================================================================
  // SELECT WITHOUT PARAMETERS
  //=========================================================================================================
  public List<PersonDTO> selectWithoutParameters() {

    String sql = "SELECT * FROM PERSON WHERE ID > 1 AND AGE > 10"; //Without SQL Parameters

    return namedParameterJdbcTemplate.query(
        sql
      , new BeanPropertyRowMapper(PersonDTO.class)
    );

  }

}
