package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
}
