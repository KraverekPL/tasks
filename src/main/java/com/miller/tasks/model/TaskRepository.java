package com.miller.tasks.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @RestResource(path = "done")
    List<Task> findByDoneIsTrue();

    @RestResource(path = "undone")
    List<Task> findByDoneIsFalse();

    @RestResource(path = "progress")
    List<Task> findByDone(@Param(value = "state") boolean done);

}
