package br.com.gsw.example.spring.profiles.poc.repository;

import br.com.gsw.example.spring.profiles.poc.domain.Poc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PocRepository extends JpaRepository<Poc, Long> {
}