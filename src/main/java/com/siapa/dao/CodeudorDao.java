
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Codeudor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "codeudorDao")
public class CodeudorDao extends GenericDao<Codeudor, Integer> {

}
