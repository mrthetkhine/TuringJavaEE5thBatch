package com.turing.mongo.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.turing.mongo.demo.model.Movie;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
public interface MovieReactiveRepository extends ReactiveMongoRepository<Movie,String>{
	List<Movie> findByDirector(String director);
	
	/*
	@Query("{ 'actors.firstName': ?0}")
	List<Movie> findByActorName(String name);
	*/
	@Query("{ 'genre': ?0}")
	Flux<Movie> findMovieWhereGeneresIs(String genre);
	
	@Query("{ 'year': ?0}")
	Flux<Movie> findByYear(Long year);
	
	 @Aggregation("{ '$project': { '_id' : '$name' } }")
	 Flux<String> findAllName();      
	 
	
	 @Aggregation(pipeline={"{\n"
	 		+ "        $addFields: {\n"
	 		+ "            \"movie_actors\": {\n"
	 		+ "                $map:{\n"
	 		+ "                    input: \"$actors\",\n"
	 		+ "                    as: \"actor\",\n"
	 		+ "                    in: '$$actor.$id'\n"
	 		+ "                }\n"
	 		+ "                \n"
	 		+ "            }\n"
	 		+ "        }\n"
	 		+ "    },\n"
	 		,
	 		 "    {\n"
	 		+ "        $unwind : \"$movie_actors\" \n"
	 		+ "    },\n"
	 		,
	 		 "    { \n"
	 		+ "        \"$lookup\": {\n"
	 		+ "            \"from\": \"actors\",\n"
	 		+ "            \"localField\": \"movie_actors\",\n"
	 		+ "            \"foreignField\": \"_id\",\n"
	 		+ "            \"as\": \"joined_actors\"\n"
	 		+ "        } \n"
	 		+ "    }"
	 		,
	 		 "    { \n"
	 		+ "        \"$group\": {\n"
	 		+ "            \"_id\": \"$_id\",\n"
	 		+ "            \"joined_actors\":{ \n"
	 		+ "                                \"$push\":{ $arrayElemAt: [ \"$joined_actors\",0] }\n"
	 		+ "                            },\n"
	 		+ "            \"doc\":{\"$first\":\"$$ROOT\"}\n"
	 		+ "        }\n"
	 		+ "    }"
	 		,
	 		 "    {   \"$replaceRoot\":{\n"
	 		+ "            \"newRoot\":{ $mergeObjects: [ '$doc',{ actors: '$joined_actors' }] },\n"
	 		+ "        }\n"
	 		+ "    }"
	 		,
	 		" { $unset: \"joined_actors\" }"
	 		,
	 		 "     { \n"
	 		+ "        \"$match\": {\n"
	 		+ "            \"actors\": {\n"
	 		+ "                $elemMatch:{\n"
	 		+ "                    \"firstName\":?0"
	 		+ "                }\n"
	 		+ "            }\n"
	 		+ "        } \n"
	 		+ "    }"})
	 Flux<Movie> getAllMovieWithLookup(String actorName);
}
