package jdbc_g13.example_6.dao;

import jdbc_g13.example_6.exception.DaoException;
import jdbc_g13.example_6.model.Abonent;

import java.util.List;

public interface AbonentDao extends BaseDao<Long, Abonent>
{
    List<Abonent> findAbonentByLastname(String patternName) throws DaoException;
}
