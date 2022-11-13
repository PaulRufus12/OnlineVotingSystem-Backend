package org.society.repo;

import org.society.entities.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionResultRepo extends JpaRepository<ElectionResult, Integer>{

}
