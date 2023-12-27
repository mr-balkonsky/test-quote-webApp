package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Role;

public interface RoleRepository {

    Role getRoleByRoleName(String roleName);
}
