package jdbc_g13.example_6;

import jdbc_g13.example_6.dao.AbonentDaoImpl;
import jdbc_g13.example_6.exception.DaoException;
import jdbc_g13.example_6.model.Abonent;

import java.util.List;
import java.util.logging.Logger;

public class SimpleJdbcMain
{
    private static final Logger logger = Logger.getLogger("LOG");

    public static void main(String[] args) throws DaoException
    {
        AbonentDaoImpl abonentDao = new AbonentDaoImpl();
        List<Abonent> abonents = abonentDao.findAbonentByLastname("Johnson");
        logger.info(abonents.toString());
    }
}