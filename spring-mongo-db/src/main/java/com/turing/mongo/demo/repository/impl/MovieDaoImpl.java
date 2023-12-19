package com.turing.mongo.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AddFieldsOperation;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
import static org.springframework.data.mongodb.core.aggregation.VariableOperators.mapItemsOf;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

//import static org.springframework.data.mongodb.core.query.Criteria.eq;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.stereotype.Repository;

import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.repository.MovieDao;

@Repository
public class MovieDaoImpl implements MovieDao{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<Movie> getAllMovieInYear(int year) {
		System.out.println("Year in dao "+year);
		List<Movie> result = this.mongoTemplate.query(Movie.class)
				  .matching(
						  query(where("year").is(year)))
				  .all();
		return result;
	}

	@Override
	public List<Movie> getAllMovie() {
		 Aggregation agg = Aggregation.newAggregation(
		            Aggregation.match(
		                    Criteria.where("year").is(2010)
		            ),
		            Aggregation.addFields().addField("movie_actors").withValue("$actors.$id").build(), 
		            Aggregation.unwind("movie_actors")
		    );

		    List<Movie> result = mongoTemplate.aggregate(agg,mongoTemplate.getCollectionName(Movie.class), Movie.class).getMappedResults();
		    //System.out.println(result);
		    return result;
	}

}
