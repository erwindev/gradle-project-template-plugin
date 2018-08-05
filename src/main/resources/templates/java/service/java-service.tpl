package ${classPackage}.service;

import ${classPackage}.dao.${daoName};
import ${classPackage}.domain.${domainName1};

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ${className} {

  public String whoAmI() {
      return "I AM GROOT!";
  }
}