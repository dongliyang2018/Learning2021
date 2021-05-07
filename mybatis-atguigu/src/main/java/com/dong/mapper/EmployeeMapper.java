package com.dong.mapper;

import com.dong.model.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);

    void addEmp(Employee employee);

    int updateEmp(Employee employee);

    boolean deleteEmpById(Integer id);

    Employee getEmployeeByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

    Employee getEmployeeByMap(Map<String,Object> map);

    List<Employee> queryEmployeeByLastName(String lastName);

    Map<String, Object> getEmployeeByIdReturnMap(Integer id);

    @MapKey("id")
    Map<Integer, Employee> queryEmployeeByLastNameReturnMap(String lastName);

    Employee getEmployeeByIdWithDept(Integer id);

    Employee getEmployeeByIdWithDeptStep(Integer id);

    List<Employee> getEmpByDeptId(Integer deptId);

    List<Employee> searchEmpByCondition(Employee employee);

    List<Employee> searchEmpByConditionTrim(Employee employee);

    List<Employee> searchEmpByConditionChoose(Employee employee);

    int updateEmpByCondition(Employee employee);

    List<Employee> searchEmpByConditionForeach(@Param("ids") List<Integer> ids);


    void batchAddEmps(@Param("emps") List<Employee> emps);
}
