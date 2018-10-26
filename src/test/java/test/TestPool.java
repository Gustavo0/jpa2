package test;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.caelum.JpaConfigurator;

public class TestPool {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();

        for(int i = 0; i < 10; i ++) {
            dataSource.getConnection();

            System.out.println(i + " - Conexões existentes: " + dataSource.getNumConnections());
            System.out.println(i + " - Conexões ocupadas: " + dataSource.getNumBusyConnections());
            System.out.println(i + " - Conexões ociosas: " + dataSource.getNumIdleConnections());

            System.out.println("");
            /*
             * Não foi até 10 porque o máximo de conexões configuradas no pool de conexões era 5
             */
        }
    }
}
