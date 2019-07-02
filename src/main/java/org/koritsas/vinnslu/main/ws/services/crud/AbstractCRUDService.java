package org.koritsas.vinnslu.main.ws.services.crud;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.koritsas.vinnslu.main.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Slf4j
public abstract class AbstractCRUDService<R extends JpaRepository, E extends Serializable, PK extends Serializable> {



    protected R repo;

    public AbstractCRUDService(R repo) {
        this.repo = repo;
    }

    @Transactional
    public E find(PK id) {


        log.info("Looking for entity with id " +id);

        if (repo.findById(id).isPresent()) {
            return (E) repo.findById(id).get();
        } else {
            throw new EntityNotFoundException("Entity with id: " + id + " not found");
        }


    }

    @Transactional(readOnly = true)
    public List<E> findAll() {

        log.info("Returning all the entities found");

        return repo.findAll();
    }


    @Transactional(rollbackFor = {EntityNotFoundException.class, ConstraintViolationException.class})
    public E create(E entity) {

        log.info("Creating new entity "+ entity.toString());

        return (E) repo.save(entity);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public E delete(PK id) {

        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Entity with id: " + id + " not found");
        }

        E entity = (E) repo.findById(id).get();


        repo.delete(entity);

        log.info("Deleted entity "+ entity.toString());

        return entity;

    }

    @Transactional(rollbackFor = {EntityNotFoundException.class, ConstraintViolationException.class})
    public E update(PK id, E entity) {

        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Entity does not exist, therefore, cannot be updated");
        }

        log.info("Updating entity "+ entity.toString());

        return (E) repo.save(entity);
    }

}
