package com.virtusa.money.manager.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.money.manager.user.service.domain.CategoryList;

@Repository
public interface CategoryListRepository extends JpaRepository<CategoryList,Long> {

}
