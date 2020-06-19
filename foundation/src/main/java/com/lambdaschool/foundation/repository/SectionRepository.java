package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository
        extends CrudRepository<Role, Long>
{
}
