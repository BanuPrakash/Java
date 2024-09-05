package com.adobe.vehiclerental.dao;

import com.adobe.vehiclerental.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, String> {
}
