/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoj
 */
public interface CRUDUserRegistrationService<E> {
        E save(E entity);

	E getById(Serializable id);

	List<E> getAll();

        void delete(Serializable id);
}
