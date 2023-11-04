package com.turingjavaee7.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.turingjavaee7.demo.model.Post;

public interface PostDao extends CrudRepository<Post, Long>{

}
