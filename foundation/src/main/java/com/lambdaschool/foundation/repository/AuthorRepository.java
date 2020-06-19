package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository
        extends CrudRepository<Role, Long>
{
}
