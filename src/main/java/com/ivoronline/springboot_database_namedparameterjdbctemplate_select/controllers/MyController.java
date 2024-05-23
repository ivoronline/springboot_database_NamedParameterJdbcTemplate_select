package com.ivoronline.springboot_database_namedparameterjdbctemplate_select.controllers;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_select.dto.PersonDTO;
import com.ivoronline.springboot_database_namedparameterjdbctemplate_select.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // SELECT RECORD
  //=========================================================================================================
  // Request             => http://localhost:8080/selectRecord?id=1&age=10
  // Returns JSON Object => { "id":1, "name":"John", "age":10 }
  @ResponseBody
  @GetMapping("/selectRecord")
  public PersonDTO selectRecord(@RequestParam Integer id, @RequestParam Integer age) {
    PersonDTO personDTO = myService.selectRecord(id, age);
    return personDTO;
  }

  //=========================================================================================================
  // SELECT RECORDS
  //=========================================================================================================
  // Request            => http://localhost:8080/selectRecords?id=1&age=10
  // Returns JSON Array => [ {"id":2, "name":"Bill", "age":20 }, { "id":3, "name":"Susan", "age":30 } ]
  @ResponseBody
  @GetMapping("/selectRecords")
  public List<PersonDTO> selectRecords(@RequestParam Integer id, @RequestParam Integer age) {
    List<PersonDTO> personDTOList = myService.selectRecords(id, age);
    return personDTOList;
  }

  //=========================================================================================================
  // SELECT WITHOUT PARAMETERS
  //=========================================================================================================
  // Request without Parameters => http://localhost:8080/selectWithoutParameters
  // Returns JSON Array         => [ {"id":2, "name":"Bill", "age":20 }, { "id":3, "name":"Susan", "age":30 } ]
  @ResponseBody
  @GetMapping("/selectWithoutParameters")
  public List<PersonDTO> selectWithoutParameters() {
    List<PersonDTO> personDTOList = myService.selectWithoutParameters();
    return personDTOList;
  }

}

