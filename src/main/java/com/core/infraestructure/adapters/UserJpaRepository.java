package com.core.infraestructure.adapters;


import org.springframework.data.jpa.repository.JpaRepository;



public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

}

