package com.boot.learn.service;

import com.boot.learn.entity.QSchool;
import com.boot.learn.entity.QStudent;
import com.boot.learn.entity.School;
import com.boot.learn.entity.Student;
import com.boot.learn.model.StudentDTO;
import com.boot.learn.repository.StudentRepository;
import com.boot.learn.untils.KJsonUtils;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/11 下午8:34
 * @Version 1.0
 */
@Service
public class StudentService {
    @Autowired
    private JPAQueryFactory queryFactory;
    
    @Autowired
    private StudentRepository studentRepository;
    
    
    public List<Student> quertDslTest() {
        List<Student> studentList = queryFactory.select(QStudent.student)
            .from(QStudent.student)
            .fetch();
        return studentList;
    }
    
    /**
     * select
     * <p>
     * sql:
     * <p>
     * SELECT student0_.id AS id1_1_, student0_.age AS age2_1_, student0_.birthday AS birthday3_1_, student0_.create_at AS create_a4_1_, student0_.name AS name5_1_
     * , student0_.remark AS remark6_1_, student0_.school_id AS school_i7_1_
     * FROM t_person student0_
     */
    public void selectTest() {
        List<Student> studentList = queryFactory.select(QStudent.student)
            .from(QStudent.student)
            .fetch();
        System.out.println(studentList);
    }
    
    /**
     * join
     * <p>
     * sql:
     * <p>
     * SELECT student0_.id AS id1_1_, student0_.age AS age2_1_, student0_.birthday AS birthday3_1_, student0_.create_at AS create_a4_1_, student0_.name AS name5_1_
     * , student0_.remark AS remark6_1_, student0_.school_id AS school_i7_1_
     * FROM t_person student0_
     * INNER JOIN t_school school1_ ON student0_.school_id = school1_.id
     * WHERE school1_.name = "向阳小学"
     */
    public void joinTest() {
        QStudent student = QStudent.student;
        QSchool school = QSchool.school;
        
        List<Student> studentList = queryFactory.select(student)
            .from(student)
            .innerJoin(school).on(student.schoolId.eq(school.id))
            .where(school.name.eq("向阳小学"))
            .fetch();
    }
    
    /**
     * order
     * <p>
     * sql:
     * <p>
     * SELECT student0_.id AS id1_1_, student0_.age AS age2_1_, student0_.birthday AS birthday3_1_, student0_.create_at AS create_a4_1_, student0_.name AS name5_1_
     * , student0_.remark AS remark6_1_, student0_.school_id AS school_i7_1_
     * FROM t_person student0_
     * ORDER BY student0_.school_id ASC, student0_.age ASC
     */
    public void orderByTest() {
        QStudent student = QStudent.student;
        
        List<Student> studentList = queryFactory.select(student)
            .from(student)
            .orderBy(student.schoolId.asc(), student.age.asc())
            .fetch();
    }
    
    /**
     * group
     * <p>
     * sql:
     * <p>
     * SELECT school0_.name AS col_0_0_
     * FROM t_school school0_
     * LEFT JOIN t_person student1_ ON school0_.id = student1_.school_id
     * GROUP BY school0_.id
     */
    public void groupByTest() {
        QStudent student = QStudent.student;
        QSchool school = QSchool.school;
        
        List<String> schoolNameList = queryFactory.select(school.name)
            .from(school)
            .leftJoin(student).on(school.id.eq(student.schoolId))
            .groupBy(school.id)
            .fetch();
    }
    
    
    /**
     * delete
     * <p>
     * sql:
     * <p>
     * delete from t_person where id= 4
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTest() {
        QStudent student = QStudent.student;
        
        queryFactory.delete(student)
            .where(student.reamrk.eq("小傻子"))
            .execute();
        
    }
    
    /**
     * update
     * <p>
     * sql:
     * <p>
     * update t_person set remark="改成归正" where name="大茂"
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateTest() {
        QStudent student = QStudent.student;
        
        long count = queryFactory.update(student)
            .where(student.name.eq("大茂"))
            .set(student.reamrk, "改成归正")
            .execute();
        
        System.out.println(count);
    }
    
    
    /**
     * subqueries
     * <p>
     * sql:
     * <p>
     * SELECT school0_.id AS id1_2_, school0_.address AS address2_2_, school0_.create_at AS create_a3_2_, school0_.name AS name4_2_
     * FROM t_school school0_
     * WHERE school0_.id IN (
     * SELECT student1_.school_id
     * FROM t_person student1_
     * WHERE student1_.score > ?
     * )
     */
    public void subqueriesTest() {
        QStudent student = QStudent.student;
        QSchool school = QSchool.school;
        
        List<School> schoolList = queryFactory.select(school)
            .from(school)
            .where(school.id.in(
                JPAExpressions.select(student.schoolId)
                    .from(student)
                    .where(student.score.gt(90L))
            )).fetch();
        
        System.out.println(schoolList);
    }
    
    
    /**
     * original query
     * <p>
     * sql:
     * <p>
     * select student0_.id as id1_1_, student0_.age as age2_1_, student0_.birthday as birthday3_1_, student0_.create_at as create_a4_1_, student0_.name as name5_1_, student0_.remark as remark6_1_,
     * student0_.school_id as school_i7_1_, student0_.score as score8_1_ from t_person student0_
     */
    public void originalQueryTest() {
        QStudent student = QStudent.student;
        Query query = queryFactory.selectFrom(student)
            .createQuery();
        List studentList = query.getResultList();
        System.out.println(studentList);
    }
    
    /**
     * single column query
     * <p>
     * sql:
     * <p>
     * SELECT student0_.name AS col_0_0_
     * FROM t_person student0_
     * WHERE student0_.score > 90
     */
    public void singleColumnQueryTest() {
        QStudent student = QStudent.student;
        
        List<String> studentNameList = queryFactory.select(student.name)
            .from(student)
            .where(student.score.gt(90L))
            .fetch();
        
        
        System.out.println(studentNameList);
    }
    
    /**
     * multiple column query
     * <p>
     * sql:
     * <p>
     * SELECT school1_.name AS col_0_0_, student0_.name AS col_1_0_, student0_.score AS col_2_0_
     * FROM t_person student0_
     * INNER JOIN t_school school1_ ON student0_.school_id = school1_.id
     * WHERE student0_.score > 90
     */
    public void multipleColumnQueryTest() {
        QStudent student = QStudent.student;
        QSchool school = QSchool.school;
        
        QStudent qStudent = new QStudent("qStudent");
        
        List<Tuple> tupleList = queryFactory.select(school.name, student.name, student.score)
            .from(student)
            .innerJoin(school).on(student.schoolId.eq(school.id))
            .where(student.score.gt(90L))
            .fetch();
        
        tupleList.stream().forEach(tuple -> {
            System.out.println("schoolName = " + tuple.get(school.name) + "     studentName = " + tuple.get(student.name) + "      studentScore = " + tuple.get(student.score));
        });
    }
    
    
    /**
     * limit
     * <p>
     * 查询前几个的结果
     * <p>
     * sql:
     * <p>
     * SELECT student0_.id AS id1_1_, student0_.age AS age2_1_, student0_.birthday AS birthday3_1_, student0_.create_at AS create_a4_1_, student0_.name AS name5_1_
     * , student0_.remark AS remark6_1_, student0_.school_id AS school_i7_1_, student0_.score AS score8_1_
     * FROM t_person student0_
     * LIMIT 2
     */
    public void limitTest() {
        QStudent student = QStudent.student;
        
        List<Student> studentList = queryFactory.select(student)
            .from(student)
            .limit(2)
            .fetch();
        
        System.out.println(studentList);
    }
    
    
    /**
     * offset
     * <p>
     * 查询第几个之后的结果
     */
    public void offsetTest() {
        QStudent student = QStudent.student;
        
        List<Student> studentList = queryFactory.select(student)
            .from(student)
            .offset(0)
            .fetch();
        
        System.out.println(KJsonUtils.toJson(studentList));
    }
    
    
    /**
     * page
     * <p>
     * sql:
     * <p>
     * SELECT student0_.id AS id1_1_, student0_.age AS age2_1_, student0_.birthday AS birthday3_1_, student0_.create_at AS create_a4_1_, student0_.name AS name5_1_
     * , student0_.remark AS remark6_1_, student0_.school_id AS school_i7_1_, student0_.score AS score8_1_
     * FROM t_person student0_
     * ORDER BY student0_.create_at DESC
     * LIMIT 1,5
     */
    public void pageQueryTest() {
        QStudent student = QStudent.student;
        
        QueryResults<Student> studentQueryResults = queryFactory.select(student)
            .from(student)
            .orderBy(student.createAt.desc())
            .offset(0L)
            .limit(5L)
            .fetchResults();
        System.out.println(studentQueryResults.getResults());
        System.out.println("total = " + studentQueryResults.getTotal());
        System.out.println("limit = " + studentQueryResults.getLimit());
        System.out.println("offset = " + studentQueryResults.getOffset());
    }
    
    
    /**
     * constructor
     * <p>
     * sql:
     * <p>
     * SELECT
     * school1_.NAME AS col_0_0_,
     * student0_.NAME AS col_1_0_,
     * student0_.score AS col_2_0_
     * FROM
     * t_person student0_
     * LEFT OUTER JOIN t_school school1_ ON ( student0_.school_id = school1_.id )
     */
    public void constructorTest() {
        QStudent student = QStudent.student;
        QSchool school = QSchool.school;
        
        List<StudentDTO> studentDTOList = queryFactory.select(Projections.constructor(StudentDTO.class, school.name, student.name, student.score))
            .from(student)
            .leftJoin(school).on(student.schoolId.eq(school.id))
            .fetch();
        
        System.out.println(KJsonUtils.toJson(studentDTOList));
    }
    
    /**
     * case expressions(when ... then ...)
     * <p>
     * sql
     * <p>
     * SELECT student0_.NAME AS col_0_0_
     * , CASE
     * WHEN student0_.score >= 0
     * AND student0_.score <= 10 THEN "喊家长"
     * WHEN student0_.score >= 11
     * AND student0_.score <= 49 THEN "习题抄5遍"
     * WHEN student0_.score >= 50
     * AND student0_.score <= 79 THEN "还需继续努力!!!"
     * WHEN student0_.score >= 80
     * AND student0_.score <= 99 THEN "继续加油!!!"
     * ELSE '恭喜满分!!!'
     * END AS col_1_0_
     * FROM t_person student0_
     */
    public void caseExpressionsTest() {
        QStudent student = QStudent.student;
        
        StringExpression sourceExpression = new CaseBuilder()
            .when(student.score.goe(0).and(student.score.loe(10))).then("喊家长!!!")
            .when(student.score.goe(11).and(student.score.loe(49))).then("习题抄5遍")
            .when(student.score.goe(50).and(student.score.loe(79))).then("还需继续努力!!!")
            .when(student.score.goe(80).and(student.score.loe(99))).then("继续加油!!!")
            .otherwise("恭喜满分!!!");
        
        
        
        List<Tuple> tupleList = queryFactory.select(student.name, sourceExpression).from(student).fetch();
        
        tupleList.stream().forEach(tuple -> {
            System.out.println("name = " + tuple.get(student.name) + "       " + tuple.get(sourceExpression));
        });
    }
    
    /**
     * expressions
     *
     * sql:
     *
     * SELECT
     * 	student0_.NAME AS col_0_0_,
     * 	date_format( student0_.birthday, '%Y-%m-%d' ) AS col_1_0_
     * FROM
     * 	t_person student0_
     */
    public void expressionsTest() {
        QStudent student = QStudent.student;
        
        List<Tuple> tupleList = queryFactory.select(student.name, Expressions.stringTemplate("DATE_FORMAT({0},'%Y-%m-%d')", student.birthday))
            .from(student)
            .fetch();
        
        tupleList.stream().forEach(tuple -> {
            System.out.println("name = " + tuple.get(student.name) + "     birthday = "
                + tuple.get(Expressions.stringTemplate("DATE_FORMAT({0},'%Y-%m-%d')", student.birthday)));
        });
    }
    
    
    public String test(){
        System.out.println("SUCCESS!!!");
        
        return "SUCCESS!!!";
    }
    
//    public void QueryDslPredicateExecutorTest(){
//        QStudent student = QStudent.student;
//
//        Iterable<Student> studentIterable = studentRepository.findAll(student.name.eq("马小跳"));
//
//        studentIterable.forEach(student1 -> System.out.println(KJsonUtils.toJson(student1)));
//    }
}
