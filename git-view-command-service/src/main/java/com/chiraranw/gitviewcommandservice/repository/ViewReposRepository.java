package com.chiraranw.gitviewcommandservice.repository;

import com.chiraranw.gitviewcommandservice.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface ViewReposRepository extends JpaRepository<View,Long> {
}
