package soa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.model.Driver;

public interface DriverRepo extends JpaRepository<Driver, Long> {

}