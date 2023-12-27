package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.Role;

public interface RoleService {

    Role getRoleByRoleName(String roleName);
}
