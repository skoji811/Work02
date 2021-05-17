package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Todo;



@Mapper
public interface TodoMapper {

	@Select("select * from todo")
	List<Todo> selectAll();
	
	@Select("select * from todo where = id =#{id}")
	Todo selectOne(Long id);

	@Options(useGeneratedKeys = true)
	@Insert("insert into todo (task) values (#{task})")
	void insert(Todo todo);
	
	@Update("update todo set task =#{task} where id = #{id}")
	int update (Todo todo);
	
	@Delete("delete from todo where id = #{id}")
	void delete(Long id);
}	
