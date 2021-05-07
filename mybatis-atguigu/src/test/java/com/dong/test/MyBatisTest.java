package com.dong.test;

import com.dong.mapper.DepartmentMapper;
import com.dong.mapper.EmployeeMapper;
import com.dong.model.Department;
import com.dong.model.Employee;
import com.dong.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 测试类
 * @version 1.0 2021/5/4
 * @author dongliyang
 */
public class MyBatisTest {

    private final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = sqlSession.selectOne("com.dong.mapper.EmployeeMapper.getEmployeeById",1);
            System.out.println("employee = " + employee);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeById(1);
            System.out.println("employee = " + employee);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAddEmp(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee("jerry", "jerry@126.com", "0");
            employeeMapper.addEmp(employee);
            System.out.println("employee = " + employee);
            sqlSession.commit();
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateEmp(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.updateEmp(new Employee(2,"jerry", "hellojerry@126.com", "0"));
            sqlSession.commit();
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteEmp(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.deleteEmpById(2);
            sqlSession.commit();
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmployeeByIdAndName(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeByIdAndName(1, "tom");
            System.out.println("employee = " + employee);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmployeeByMap(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("lastName", "tom");
            Employee employee = employeeMapper.getEmployeeByMap(map);
            System.out.println("employee = " + employee);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testQueryEmployeeByLastName(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.queryEmployeeByLastName("%t%");
            for (Employee employee : employees) {
                System.out.println("employee = " + employee);
            }
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmployeeByIdReturnMap(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String,Object> employee = employeeMapper.getEmployeeByIdReturnMap(1);
            System.out.println("employee = " + employee);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testQueryEmployeeByLastNameReturnMap(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<Integer,Employee> employees = employeeMapper.queryEmployeeByLastNameReturnMap("%t%");
            employees.forEach((k,v) -> System.out.println("k = " + k + ",v = " + v));
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmployeeByIdWithDept(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employeeByIdWithDept = employeeMapper.getEmployeeByIdWithDept(1);
            System.out.println("employeeByIdWithDept = " + employeeByIdWithDept);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmployeeByIdWithDeptStep(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employeeByIdWithDept = employeeMapper.getEmployeeByIdWithDeptStep(1);
//            System.out.println("employeeByIdWithDeptStep = " + employeeByIdWithDept);
            System.out.println("employeeByIdWithDept.getLastName() = " + employeeByIdWithDept.getLastName());

            System.out.println("employeeByIdWithDept.getDept().getDepartmentName() = " + employeeByIdWithDept.getDept().getDepartmentName());
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetDepartmentPlus(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department dept = departmentMapper.getDeptByIdPlus(2);
            System.out.println("dept = " + dept);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testGetDepartmentStep(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department dept = departmentMapper.getDeptByIdStep(2);
            System.out.println("dept.getDepartmentName() = " + dept.getDepartmentName());
            System.out.println("dept.getEmps() = " + dept.getEmps());
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSearchEmpByCondition(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setId(1);
            List<Employee> empList = mapper.searchEmpByCondition(employee);
            System.out.println("empList = " + empList);

        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSearchEmpByConditionTrim(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setId(1);
            List<Employee> empList = mapper.searchEmpByConditionTrim(employee);
            System.out.println("empList = " + empList);

        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSearchEmpByConditionChoose(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setId(1);
            List<Employee> empList = mapper.searchEmpByConditionChoose(employee);
            System.out.println("empList = " + empList);

        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateEmpCondition(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.updateEmpByCondition(new Employee(2,"jerry2", null, null));
            sqlSession.commit();
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSearchEmpByConditionForeach(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> empList = mapper.searchEmpByConditionForeach(null);
            System.out.println("empList = " + empList);


            List<Employee> empList2 = mapper.searchEmpByConditionForeach(new ArrayList<>(0));
            System.out.println("empList2 = " + empList2);

            List<Employee> empList3 = mapper.searchEmpByConditionForeach(Arrays.asList(1,2,3));
            System.out.println("empList3 = " + empList3);
        } catch (Exception e) {
            logger.error("An exception occurred while invoking selectOne method",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testBatchAddEmps(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp1 = new Employee("jerry3", "jerry3@126.com", "0",new Department(1, null));
            Employee emp2 = new Employee("jerry4", "jerry4@126.com", "0",new Department(2, null));
            Employee emp3 = new Employee("jerry5", "jerry5@126.com", "0",new Department(2, null));
            employeeMapper.batchAddEmps(Arrays.asList(emp1,emp2,emp3));
            sqlSession.commit();
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testCache01(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmployeeById(1);
            System.out.println("emp01 = " + emp01);

            Employee emp02 = mapper.getEmployeeById(1);
            System.out.println("emp02 = " + emp02);

            //同一个sqlSession,参数又一样。所以使用一级缓存。emp01等于emp02
            System.out.println(emp01 == emp02);
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testCache02(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmployeeById(1);
            System.out.println("emp01 = " + emp01);

            Employee emp02 = mapper.getEmployeeById(2);
            System.out.println("emp02 = " + emp02);
            //同一个sqlSession,但参数不一样。所以使用一级缓存失效。会发送两次sql
            System.out.println(emp01 == emp02);
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testCache03(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmployeeById(1);
            System.out.println("emp01 = " + emp01);

            //中间执行了增删改操作
            mapper.batchAddEmps(Arrays.asList(new Employee("test","test@126.com","1",new Department(1, null))));

            Employee emp02 = mapper.getEmployeeById(1);
            System.out.println("emp02 = " + emp02);
            //同一个sqlSession,参数一样。但中间执行了增删改操作，一级缓存失效。会发送两次sql
            System.out.println(emp01 == emp02);
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testCache04(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmployeeById(1);
            System.out.println("emp01 = " + emp01);

            //手动清除了一级缓存
            sqlSession.clearCache();

            Employee emp02 = mapper.getEmployeeById(1);
            System.out.println("emp02 = " + emp02);
            //同一个sqlSession,参数一样。但手动清除了一级缓存，一级缓存失效。会发送两次sql
            System.out.println(emp01 == emp02);
        } catch (Exception e) {
            logger.error("exception",e);
        } finally {
            sqlSession.close();
        }
    }
}
