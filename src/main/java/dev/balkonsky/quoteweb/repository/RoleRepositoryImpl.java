package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByRoleName(String roleName) {
        var query = "SELECT id, name FROM roles WHERE name = :roleName";
        return (Role) entityManager.createNativeQuery(query, Role.class)
                .setParameter("roleName", roleName)
                .getSingleResult();
    }
}