package com.aop.tpma.dao;

import com.aop.tpma.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JpaRepository interface extends CrudRepository and provides methods out of the box.
 * You can use it to create, read, update, delete, data in a given database (for example, POSTGRESQL).
 **/
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
