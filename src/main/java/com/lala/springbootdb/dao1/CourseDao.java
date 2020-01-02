package com.lala.springbootdb.dao1;

import com.lala.springbootdb.pojo.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CourseDao {

    public int doinsert(@Param("course") Course course);
}
