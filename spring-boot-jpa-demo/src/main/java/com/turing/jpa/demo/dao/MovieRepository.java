package com.turing.jpa.demo.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;

import jakarta.transaction.Transactional;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByYear(Integer year);
	List<Movie> findByTitle(String title);
	List<Movie> findByGenreAndYear(String genre,Integer year);
	List<Movie> findByGenreOrYear(String genre,Integer year);
	List<Movie> findDistinctByGenre(String genre);
	List<Movie> findByYearBetween(Integer startYear,Integer endYear);
	List<Movie> findByYearLessThan(Integer year);
	List<Movie> findByCreatedAtIsNull();
	List<Movie> findByTitleLike(String title);
	List<Movie> findAllByOrderByYear();
	List<Movie> findAllByYearIn(Collection<Integer> years);
	
	Movie findTopByOrderByYearDesc();
	
	@Query("SELECT count(m) FROM Movie m WHERE m.genre = :genre")
	int findTotalMovieByGenres(@Param("genre") String genere);
	
	@Query(value="SELECT * FROM movie;",nativeQuery=true)
	List<Movie> findAllMovie();
	
	@Query(value="from Movie m join fetch m.movieDetails movieDetails")
	List<Movie> findAllMovieWithoutNPlusOne();
	
	@Query("SELECT distinct(m.genre) FROM Movie m")
	List<String> getAllGeneres();
	
	@Query(value="SELECT genre,count(*)As count FROM movie GROUP BY genre;",nativeQuery=true)
	List<GenreCountDto> getAllGeneresCount();
	
	@Query(value="SELECT new com.turing.jpa.demo.model.dto.GenreCountDtoTwo( m.genre,count(m.genre)) "
			+ "FROM Movie m GROUP BY m.genre"
			)
	List<GenreCountDtoTwo> getAllGeneresCountTwo();
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Movie m SET m.year = ?2 WHERE m.id = ?1")
	int updateYearByMovieId(Long movieId,Integer year);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Movie m WHERE m.id = ?1")
	int deleteMovieById(Long movieId);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM Movie m WHERE m.id = ?1",nativeQuery=true)
	int deleteMovieByIdTwo(Long movieId);
	
	//@Query(value="from Movie m JOIN m.comments comments JOIN m.actors actors")
	@Query(value="FROM Movie m")
	List<Movie> findAllMovieJPQL();
}
