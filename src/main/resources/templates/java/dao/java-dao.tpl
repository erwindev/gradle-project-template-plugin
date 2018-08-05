package ${classPackage}.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ${classPackage}.domain.${domainName1};

@Repository
public interface ${className} extends JpaRepository<${domainName1}, Long>{
}